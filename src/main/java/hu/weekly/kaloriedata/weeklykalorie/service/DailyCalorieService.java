package hu.weekly.kaloriedata.weeklykalorie.service;

import hu.weekly.kaloriedata.weeklykalorie.entity.DailyCalorieDataEntity;
import hu.weekly.kaloriedata.weeklykalorie.model.DailyCalorie;
import hu.weekly.kaloriedata.weeklykalorie.model.DailyMax;
import hu.weekly.kaloriedata.weeklykalorie.model.dto.DailyCalorieData;
import hu.weekly.kaloriedata.weeklykalorie.model.dto.Pair;
import hu.weekly.kaloriedata.weeklykalorie.repo.DailyCalorieDataRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class DailyCalorieService extends BaseService<DailyCalorieData, DailyCalorieDataEntity, DailyCalorieDataRepository> {

    private final Pair<DailyCalorie, DailyMax> calorieDailyMaxPair;
    private final FoodService foodService;

    public DailyCalorieService(@NonNull Pair<DailyCalorie, DailyMax> calorieDailyMaxPair,
                               @NonNull DailyCalorieDataRepository repository,
                               @NonNull FoodService foodService) {
        super(repository);
        this.calorieDailyMaxPair = calorieDailyMaxPair;
        this.foodService = foodService;
    }

    DailyCalorieDataEntity toEntity() {
        DailyCalorieData dto = toDto();
        return DailyCalorieDataEntity.builder()
                .dailyCal(dto.getDailyCal())
                .max(dto.getMax())
                .foodSumCarbo(dto.getFoodSumCarbo())
                .dailyCal(dto.getDailyCal())
                .foodSum(dto.getFoodSum())
                .foodSumFat(dto.getFoodSumFat())
                .foodSumProtein(dto.getFoodSumProtein())
                .foods(foodService.toFoodEntityList(dto.getFoods()))
                .build();
    }

    DailyCalorieData toDto() {
        return DailyCalorieData.builder()
                .dailyCal(calorieDailyMaxPair.getSecond().getDailycal())
                .foodSumFat(calorieDailyMaxPair.getFirst().getRfoodsumFat())
                .foodSumCarbo(calorieDailyMaxPair.getFirst().getRfoodsumCarbo())
                .foodSumProtein(calorieDailyMaxPair.getFirst().getRfoodsumProtein())
                .max(calorieDailyMaxPair.getSecond().getMax())
                .foodSum(calorieDailyMaxPair.getFirst().getRfoodsum())
                .foods(foodService.toFoodList(calorieDailyMaxPair.getFirst().getResults()))
                .build();
    }
}
