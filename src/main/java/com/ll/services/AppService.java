package com.ll.services;

import com.ll.App;
import com.ll.entities.appEntity;
import com.ll.repositories.AppRepository;

import java.util.Optional;

public class AppService {
    public AppRepository appRepository;

    public AppService() {
        this.appRepository = new AppRepository();
    }

    public appEntity create(String content) {
        appEntity entity = new appEntity(0, content);
        appRepository.add(entity);
        return entity;
    }

    public List<appEntity> findAll() {
        return appRepository.findAll();
    }

    public boolean removeById(int id) {
        return appRepository.removeById(id);
    }

    public Optional<appEntity> findById(int id) {
        return appRepository.findById(id);
    }

    public void update(appEntity entity, String content) {
        entity.setContent(content);

        appRepository.update(entity);
    }
}
