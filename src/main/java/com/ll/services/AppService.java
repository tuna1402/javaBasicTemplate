package com.ll.services;

import com.ll.App;
import com.ll.repositories.AppRepository;

import java.util.Optional;

public class AppService {
    public AppRepository appRepository;

    public AppService() {
        this.appRepository = new AppRepository();
    }

    public Entity create(String content) {
        Entity entity = new Entitiy(0, content);
        appRepository.add(entity);
        return entity;
    }

    public List<Entity> findAll() {
        return appRepository.findAll();
    }

    public boolean removeById(int id) {
        return appRepository.removeById(id);
    }

    public Optional<Entity> findById(int id) {
        return appRepository.findById(id);
    }

    public void update(Entity entity, String content) {
        entity.setContent(content);

        appRepository.update(entity);
    }
}
