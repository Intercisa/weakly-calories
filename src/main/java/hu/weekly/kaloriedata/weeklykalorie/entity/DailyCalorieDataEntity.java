package hu.weekly.kaloriedata.weeklykalorie.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class DailyCalorieDataEntity extends BaseEntity {
    private Long id;
    private String foodSum;
    private String foodSumFat;
    private String foodSumProtein;
    private String foodSumCarbo;
    private double max;
    private String dailyCal;
    List<FoodDataEntity> foods;
}
