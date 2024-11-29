package com.ll;

import com.ll.controllers.SystemController;
import com.ll.controllers.appController;

import java.util.Scanner;

public class App {
    public SystemController systemController;
    public appController controller;
    public Scanner sc;

    public App() {
        sc = new Scanner(System.in);
        systemcontroller = new SysmtemController();
        appController = new AppController(sc);
    }

    public void run() {
        System.out.println("App start");
        String cmd = sc.nextLine();

        controller.sampleData();

        while(true) {
            if (cmd.equals("Exit")) {
                systemController.appExit();
                break;
            } else if (cmd.equals("Create")) {
                appController.create();
            } else if (cmd.equals("Read")) {
                appController.read();
            } else if (cmd.equals("Update")) {
                appController.update(cmd);
            } else if (cmd.equals("Delete")) {
                appController.delete();
            }
        }
        sc.close();
    }
}
