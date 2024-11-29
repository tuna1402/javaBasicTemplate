package com.ll.repositories;

import com.ll.entities.AppEntity;

import java.util.List;
import java.util.Optional;

public interface AppRepository {
    void add(AppEntity entity);

    List<AppEntity> findAll();

    boolean removeById(int id);

    Optional<AppEntity> findById(int id);

    void update(AppEntity entity);
}
