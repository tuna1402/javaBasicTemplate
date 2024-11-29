package com.ll.controllers;

import com.ll.entities.AppEntity;
import com.ll.services.AppService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AppController {
    public AppService appService;
    public Scanner sc;

    public AppController(Scanner sc) {
        this.appService = new AppService();
        this.sc = sc;
    }

    public void sampleData() {
        appService.create("content1");
        appService.create("content2");
    }

    public void create() {
        System.out.println("Enter: ");
        String content = sc.nextLine();

        AppEntity entity = appService.create(content);

        System.out.println("created %d content.".formatted(entity.getId()));
    }

    public void read() {
        List<AppEntity> entities = appService.findAll();

        for (AppEntity entity : entities) {
            System.out.println(entity.getId() + entity.getContent());
        }
    }

    public void update(String cmd) {
        int id = Integer.parseInt(cmd);

        Optional<AppEntity> revisingContent = appService.findById(id);

        if (revisingContent.isEmpty()) {
            System.out.println(id + " not exist.");
            return;
        }

        AppEntity foundedContent = revisingContent.get();
        System.out.println("origin content");
        System.out.println("Enter content: ");
        String content = sc.nextLine();

        appService.update(foundedContent, content);

        System.out.println("revised content is finished.");
    }

    public void delete(String cmd) {
        int id = Integer.parseInt(cmd);

        boolean removed = appService.removeById(id);

        if (removed) System.out.println(id + " delted");
        else System.out.println(id + " not exist");
    }
}
