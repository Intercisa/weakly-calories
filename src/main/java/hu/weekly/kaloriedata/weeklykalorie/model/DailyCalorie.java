package hu.weekly.kaloriedata.weeklykalorie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyCalorie {
    private List<Entry> results;
    private String rfoodsum;
    private String rfoodsumFat;
    private String rfoodsumProtein;
    private String rfoodsumCarbo;
}