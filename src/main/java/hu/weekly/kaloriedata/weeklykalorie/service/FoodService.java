package hu.weekly.kaloriedata.weeklykalorie.service;

import hu.weekly.kaloriedata.weeklykalorie.entity.FoodDataEntity;
import hu.weekly.kaloriedata.weeklykalorie.model.Entry;
import hu.weekly.kaloriedata.weeklykalorie.model.dto.FoodData;
import hu.weekly.kaloriedata.weeklykalorie.repo.FoodRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService extends BaseService<FoodData, FoodDataEntity, FoodRepository> {
    public FoodService(@NonNull FoodRepository repository) {
        super(repository);
    }

    public List<FoodData> toFoodList(List<Entry> entries) {
        ArrayList<FoodData> foods = new ArrayList<>();
        entries.forEach(entry -> foods.add(toFoodDataDto(entry)));
        return foods;
    }

    public List<FoodDataEntity> toFoodEntityList(List<FoodData> foodDataList) {
        ArrayList<FoodDataEntity> foods = new ArrayList<>();
        foodDataList.forEach(foodData -> foods.add(toFoodDataEntity(foodData)));
        return foods;
    }

    private FoodDataEntity toFoodDataEntity(FoodData foodData) {
        return FoodDataEntity.builder().calorie(foodData.getCalorie())
                .carbo(foodData.getCarbo())
                .cleanedName(foodData.getName())
                .displayName(foodData.getDisplayName())
                .name(foodData.getName())
                .protein(foodData.getProtein())
                .quantity(foodData.getQuantity())
                .sumWeight(foodData.getSumWeight())
                .unitDisplayName(foodData.getUnitDisplayName())
                .fat(foodData.getFat())
                .unitDisplayName2(foodData.getUnitDisplayName2())
                .weight(foodData.getWeight())
                .build();
    }

    private FoodData toFoodDataDto(Entry entry) {
        return FoodData.builder().calorie(entry.getNCalorie())
                .carbo(entry.getNCarbo())
                .cleanedName(entry.getCName())
                .displayName(entry.getCDisplayName())
                .name(entry.getCName())
                .protein(entry.getNProtein())
                .quantity(entry.getNQuantity())
                .sumWeight(entry.getSumWeight())
                .unitDisplayName(entry.getUnitDisplayName())
                .fat(entry.getNFat())
                .unitDisplayName2(entry.getUnitDisplayName2())
                .weight(entry.getNWeight())
                .build();
    }
}
