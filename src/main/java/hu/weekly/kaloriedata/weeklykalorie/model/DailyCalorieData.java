package hu.weekly.kaloriedata.weeklykalorie.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyCalorieData {
    public List<Entry> results;
    public String rfoodsum;
    public String rfoodsumFat;
    public String rfoodsumProtein;
    public String rfoodsumCarbo;
}