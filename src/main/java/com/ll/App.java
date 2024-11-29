package com.ll;

import com.ll.controllers.SystemController;
import com.ll.controllers.AppController;

import java.util.Scanner;

public class App {
    public SystemController systemController;
    public AppController appController;
    public Scanner sc;

    public App() {
        sc = new Scanner(System.in);
        systemController = new SystemController();
        appController = new AppController(sc);
    }

    public void run() {
        System.out.println("App start");
        String cmd = sc.nextLine();

        appController.sampleData();

        label:
        while(true) {
            switch (cmd) {
                case "Exit":
                    systemController.appExit();
                    break label;
                case "Create":
                    appController.create();
                    break;
                case "Read":
                    appController.read();
                    break;
                case "Update":
                    appController.update(cmd);
                    break;
                case "Delete":
                    appController.delete(cmd);
                    break;
            }
        }
        sc.close();
    }
}
