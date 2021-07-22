package hu.weekly.kaloriedata.weeklykalorie.model.dto;

import hu.weekly.kaloriedata.weeklykalorie.model.CalData;
import lombok.Value;

@Value
public class Pair<K, V>  implements CalData {
    K first;
    V second;
}