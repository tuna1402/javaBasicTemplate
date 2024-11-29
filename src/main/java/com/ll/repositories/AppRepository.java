package com.ll.repositories;

import java.util.Optional;

public interface AppRepository {
    void add(appEntity entity);

    List<appEntity> findAll();

    boolean removeById(int id);

    Optional<appEntity> findById(int id);

    void update(appEntity entity);
}
