package com.ll.services;

import com.ll.entities.AppEntity;
import com.ll.repositories.AppMemoryRepository;
import com.ll.repositories.AppRepository;

import java.util.List;
import java.util.Optional;

public class AppService {
    public AppRepository appRepository;

    public AppService() {
        this.appRepository = new AppMemoryRepository();
    }

    public AppEntity create(String content) {
        AppEntity entity = new AppEntity(0, content);
        appRepository.add(entity);
        return entity;
    }

    public List<AppEntity> findAll() {
        return appRepository.findAll();
    }

    public boolean removeById(int id) {
        return appRepository.removeById(id);
    }

    public Optional<AppEntity> findById(int id) {
        return appRepository.findById(id);
    }

    public void update(AppEntity entity, String content) {
        entity.setContent(content);

        appRepository.update(entity);
    }
}
