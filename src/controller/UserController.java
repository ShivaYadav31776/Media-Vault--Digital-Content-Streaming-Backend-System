package controller;

import java.io.IOException;
import java.util.Scanner;

import data.Nav;
import model.Greetings;
import service.AdminService;
import service.Menu;
import service.UserService;

public class UserController {
    public void user() throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        UserService userService = new UserService();
        Greetings greetings = new Greetings();
        AdminService adminService = new AdminService();
        while (true) {
            menu.userMenu();
            greetings.enter();
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println(
                            "                                                                  =========================================== ");
                    System.out.println(
                            "                                                                    ||             1.REGISTER          ||");
                    System.out.println(
                            "                                                                    ||             2.LOGIN             ||");
                    System.out.println(
                            "                                                                  =========================================== ");
                    greetings.enter();

                    int choose = sc.nextInt();
                    switch (choose) {
                        case 1:
                            userService.registerUser();
                            break;
                        case 2:
                            userService.login();
                            break;
                        default:
                            break;
                    }
                    break;

                case 2:
                    adminService.showSongs();
                    break;

                case 3:
                    adminService.searchSong("guest");
                    break;

                case 4:
                    userService.trendingTop10Songs();
                    break;

                case 5:
                    return;

                default:
                    break;
            }
        }
    }
}