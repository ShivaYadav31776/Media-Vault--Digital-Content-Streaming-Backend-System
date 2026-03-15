package controller;

import java.io.IOException;
import java.util.Scanner;
import model.Greetings;
import service.AdminService;
import service.Menu;

public class AdminController {
    public void admin() throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        AdminService adminService = new AdminService();
        Menu menu = new Menu();
        Greetings greetings = new Greetings();

        System.out
                .print("                                                                      Enter Admin id:-");
        int id = sc.nextInt();

        System.out
                .print("                                                                      Enter Admin password:-");
        String password = sc.nextLine();
        sc.nextLine();

        if (id != 1234 || password.equals("adminpass")) {
            System.out.println(
                    "                                                                      Wrong Credentials");
            return;
        }

        while (true) {
            menu.AdminMenu();
            greetings.enter();
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    adminService.addSong();
                    break;

                case 2:
                    adminService.showAnalytics();
                    break;

                case 3:
                    adminService.trendingTop3Songs();
                    break;

                case 4:
                    adminService.showSongs();
                    break;
                    

                case 5:
                    System.out.println("deleted" );
                    break;    

                default:
                    break;
            }
        }
    }
}
