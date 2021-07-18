package hu.weekly.kaloriedata.weeklykalorie.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.weekly.kaloriedata.weeklykalorie.model.DailyCalorie;
import hu.weekly.kaloriedata.weeklykalorie.model.DailyCalorieData;
import lombok.SneakyThrows;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebScrapService {
    final static String TXT_USERNAME = "txtusern=";
    final static String USERNAME = "intercisa";
    final static String TXP_PASSWORD = "txtpassw=";
    final static String PASSWORD = "Sagi11arius";
    final static String URL = "https://kaloriabazis.hu/bejelentkezes";
    final static Pattern CALORIE_DAILY_DATA = Pattern.compile("\"results\".*\"rlast_10\"");
    final static Pattern CALORIE_STANDARD = Pattern.compile("\"graptype\".*\"dailycal\":\"[0-9]{4}\"");

    @SneakyThrows
    private String scrapPage() {
        Request request = Request.Post(URL);
        String body = TXT_USERNAME + USERNAME + "&" + TXP_PASSWORD + PASSWORD;
        request.bodyString(body, ContentType.APPLICATION_FORM_URLENCODED);
        request.setHeader("Content-Type", ContentType.APPLICATION_FORM_URLENCODED.toString());
        HttpResponse httpResponse = request.execute().returnResponse();
        if (httpResponse.getEntity() != null) {
            return EntityUtils.toString(httpResponse.getEntity());
        }
        return null;
    }

    @SneakyThrows
    public DailyCalorieData scrapDailyCalorieData() {
        String html = scrapPage();

        assert html != null;
        Matcher m = CALORIE_DAILY_DATA.matcher(html);
        DailyCalorieData dailyCalorieData = null;
        if (m.find()) {
            String jsonData = "{" + m.group(0).substring(0, m.group(0).length() - 11) + "}";
            ObjectMapper mapper = new ObjectMapper();
            dailyCalorieData = mapper.readValue(jsonData, DailyCalorieData.class);
        }
        return dailyCalorieData;
    }

    @SneakyThrows
    public DailyCalorie scrapStandardCalorie() {
        String html = scrapPage();

        assert html != null;
        Matcher m = CALORIE_STANDARD.matcher(html);
        DailyCalorie dailyCalorie = null;
        if (m.find()) {
            String jsonMax = "{" + m.group(0) + "}";
            ObjectMapper mapper = new ObjectMapper();
            dailyCalorie = mapper.readValue(jsonMax, DailyCalorie.class);
        }
        return dailyCalorie;
    }
}
