package hu.weekly.kaloriedata.weeklykalorie.model.dto;

import hu.weekly.kaloriedata.weeklykalorie.model.BaseModel;
import hu.weekly.kaloriedata.weeklykalorie.model.CalData;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class DailyCalorieData extends BaseModel implements CalData {
    private Long id;
    private String foodSum;
    private String foodSumFat;
    private String foodSumProtein;
    private String foodSumCarbo;
    private double max;
    private String dailyCal;
    List<FoodData> foods;
}
