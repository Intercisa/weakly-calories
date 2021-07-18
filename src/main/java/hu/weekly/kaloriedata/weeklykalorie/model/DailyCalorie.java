package hu.weekly.kaloriedata.weeklykalorie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyCalorie{
    public String graptype;
    public String type;
    public double position;
    public double max;
    public String error;
    public String dailycal;
}