package controller;

import java.util.Scanner;

import model.Greetings;
import service.AdminService;
import service.Menu;

public class AdminController {
    public void admin() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        AdminService adminService = new AdminService();
        Menu menu = new Menu();
        Greetings greetings = new Greetings();
        while (true) {
            menu.AdminMenu();
            greetings.enter();
            int input = sc.nextInt();

            switch (input) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:
                    adminService.showAnalytics();
                    break;

                case 4:

                    break;

                default:
                    break;
            }
        }
    }
}
