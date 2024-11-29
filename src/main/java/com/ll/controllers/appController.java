package com.ll.controllers;

import java.util.Optional;
import java.util.Scanner;

public class appController {
    public AppService appService;
    public Scanner sc;

    public appController(Scanner sc) {
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

        Entity entity = appService.create(content);

        System.out.println("created %d content.".formatted(entity.getId()));
    }

    public void read() {
        List<Entity> contents = appService.findAll();

        for (Entity element : contents) {
            System.out.println(element.getId() + element.getContent);
        }
    }

    public void update(String cmd) {
        int id = Integer.parseInt(cmd);

        Optional<Entity> revisingContent = appService.findId(id);

        if (revisingContent.isEmpty()) {
            System.out.println(id + " not exist.");
            return;
        }

        Entity foundedContent = revisingContent.get();
        System.out.println("origin content");
        System.out.println("Enter content: ");
        String content = sc.nextLine();

        appSerive.update(foundedContent, content);

        System.out.println("revised content is finished.");
    }

    public void delete(String cmd) {
        int id = Integer.parseInt(cmd);

        boolean removed = appService.removeById(id);

        if (removed) System.out.println(id + " delted");
        else System.out.println(id + " not exist");
    }
}
