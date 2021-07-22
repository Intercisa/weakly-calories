package hu.weekly.kaloriedata.weeklykalorie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyMax {
    private String graptype;
    private String type;
    private double position;
    private double max;
    private String error;
    private String dailycal;
}