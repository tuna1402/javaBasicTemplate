package com.ll.repositories;

import com.ll.entities.AppEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppMemoryRepository implements AppRepository {
    public List<AppEntity> entities;
    public int lastId;

    public AppMemoryRepository() {
        this.entities = new ArrayList<>();
        this.lastId = 0;
    }

    public void add(AppEntity entity) {
        entity.setId(++lastId);
        entities.add(entity);
    }

    public List<AppEntity> findAll() {
        return entities;
    }

    public boolean removeById(int id) {
        return entities.removeIf(e -> e.getId() == id);
    }

    public Optional<AppEntity> findById(int id) {
        return entities.stream().filter(e -> e.getId() == id).findFirst();
    }

    public void update(AppEntity entity) {}
}
