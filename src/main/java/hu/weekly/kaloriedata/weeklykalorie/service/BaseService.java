package hu.weekly.kaloriedata.weeklykalorie.service;

import hu.weekly.kaloriedata.weeklykalorie.entity.BaseEntity;
import hu.weekly.kaloriedata.weeklykalorie.model.CalData;
import hu.weekly.kaloriedata.weeklykalorie.repo.BaseRepository;
import lombok.NonNull;

public abstract class BaseService<Dto extends CalData, EEntity extends BaseEntity, ERepository extends BaseRepository> {

    protected final ERepository repository;
    public BaseService(@NonNull ERepository repository) {
        this.repository = repository;
    }

}
