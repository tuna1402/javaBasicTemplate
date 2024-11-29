package com.ll.repositories;

import java.util.ArrayList;
import java.util.Optional;

public class appMemoryRepository implements AppRepository {
    public List<appEntity> entity;
    public int lastId;

    public appMemoryRepository() {
        this.entity = new ArrayList<>();
        this.lastId = 0;
    }

    public void add(appEntity entity) {
        entity.setId(++lastId);
        entity.create(entity);
    }

    public List<appEntity> findAll() {
        return entity;
    }

    public boolean removeById(int id) {
        return entity.removeIf(e -> e.getId() == id);
    }

    public Optional<appEntity> findById(int id) {
        return entity.stream();.filter(e -> e.getId() == id).findFirst();
    }

    public void update(appEntity entity) {}
}
