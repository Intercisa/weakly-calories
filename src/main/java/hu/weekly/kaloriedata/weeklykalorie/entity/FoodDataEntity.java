package hu.weekly.kaloriedata.weeklykalorie.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodDataEntity extends BaseEntity {
    private double fat;
    private double carbo;
    private double protein;
    private double calorie;
    private double weight;
    private String displayName;
    private double quantity;
    private String unitDisplayName;
    private String unitDisplayName2;
    private double sumWeight;
    private String name;
    private String cleanedName;
}
