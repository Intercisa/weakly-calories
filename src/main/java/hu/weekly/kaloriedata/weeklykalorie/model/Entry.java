package hu.weekly.kaloriedata.weeklykalorie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entry {
    private Long nID;
    private double nFat;
    private double nCarbo;
    private double nProtein;
    private double nCalorie;
    private double nWeight;
    private String cDisplayName;
    private double nQuantity;
    private String unitDisplayName;
    private double bRecept;
    private int nFoodID;
    private int nFoodUnitRef;
    private String unitDisplayName2;
    private double sumWeight;
    private String cName;
    private String nDayoftimeRef;
    private Object nSynonymFoodRef;
    private int bSum;
    private String cleanedname;
    private String url;
    private String url_id;
    private String unit_id;
    private String unit_text;
    private String food_id;
    private Object fav_id;
    private Object fb_table_id;
    private String bOriginal;
    private String food_nCreated;
    private int edit_able;
    private String hour_min;
}