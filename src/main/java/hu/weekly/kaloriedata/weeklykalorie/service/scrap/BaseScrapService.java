package hu.weekly.kaloriedata.weeklykalorie.service.scrap;

import hu.weekly.kaloriedata.weeklykalorie.model.CalData;

import java.util.regex.Pattern;

public abstract class BaseScrapService<TDto extends CalData> {
    final protected static String TXT_USERNAME = "txtusern=";
    final protected static String USERNAME = "intercisa";
    final protected static String TXP_PASSWORD = "txtpassw=";
    final protected static String PASSWORD = "********";
    final protected static String URL = "https://kaloriabazis.hu/bejelentkezes";
    final protected static Pattern CALORIE_DAILY_DATA = Pattern.compile("\"results\".*\"rlast_10\"");
    final protected static Pattern CALORIE_STANDARD = Pattern.compile("\"graptype\".*\"dailycal\":\"[0-9]{4}\"");
    abstract TDto getData();
}
