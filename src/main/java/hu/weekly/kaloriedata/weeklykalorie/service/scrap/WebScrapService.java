package hu.weekly.kaloriedata.weeklykalorie.service.scrap;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.weekly.kaloriedata.weeklykalorie.model.DailyMax;
import hu.weekly.kaloriedata.weeklykalorie.model.DailyCalorie;
import hu.weekly.kaloriedata.weeklykalorie.model.Entry;
import hu.weekly.kaloriedata.weeklykalorie.model.dto.DailyCalorieData;
import hu.weekly.kaloriedata.weeklykalorie.model.dto.FoodData;
import hu.weekly.kaloriedata.weeklykalorie.model.dto.Pair;
import lombok.SneakyThrows;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebScrapService extends BaseScrapService<Pair<DailyCalorie, DailyMax>> {

    private final String page;

    public WebScrapService() {
        page = scrapPage();
    }

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
    private DailyCalorie scrapDailyCalorieData() {
        String html = page;

        assert html != null;
        Matcher m = CALORIE_DAILY_DATA.matcher(html);
        DailyCalorie dailyCalorieData = null;
        if (m.find()) {
            String jsonData = "{" + m.group(0).substring(0, m.group(0).length() - 11) + "}";
            ObjectMapper mapper = new ObjectMapper();
            dailyCalorieData = mapper.readValue(jsonData, DailyCalorie.class);
        }
        return dailyCalorieData;
    }

    @SneakyThrows
    private DailyMax scrapStandardCalorie() {
        String html = page;

        assert html != null;
        Matcher m = CALORIE_STANDARD.matcher(html);
        DailyMax dailyMax = null;
        if (m.find()) {
            String jsonMax = "{" + m.group(0) + "}";
            ObjectMapper mapper = new ObjectMapper();
            dailyMax = mapper.readValue(jsonMax, DailyMax.class);
        }
        return dailyMax;
    }

    @Override
    public Pair<DailyCalorie, DailyMax> getData() {
        return new Pair<>(scrapDailyCalorieData(), scrapStandardCalorie());
    }
}
