package hu.weekly.kaloriedata.weeklykalorie.model.dto;

import hu.weekly.kaloriedata.weeklykalorie.model.BaseModel;
import hu.weekly.kaloriedata.weeklykalorie.model.CalData;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class FoodData extends BaseModel implements CalData {
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
