package hu.weekly.kaloriedata.weeklykalorie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entry {
    public Long nID;
    public double nFat;
    public double nCarbo;
    public double nProtein;
    public double nCalorie;
    public double nWeight;
    public String cDisplayName;
    public double nQuantity;
    public String unitDisplayName;
    public double bRecept;
    public int nFoodID;
    public int nFoodUnitRef;
    public String unitDisplayName2;
    public double sumWeight;
    public String cName;
    public String nDayoftimeRef;
    public Object nSynonymFoodRef;
    public int bSum;
    public String cleanedname;
    public String url;
    public String url_id;
    public String unit_id;
    public String unit_text;
    public String food_id;
    public Object fav_id;
    public Object fb_table_id;
    public String bOriginal;
    public String food_nCreated;
    public int edit_able;
    public String hour_min;
}