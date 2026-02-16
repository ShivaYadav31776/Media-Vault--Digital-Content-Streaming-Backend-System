package controller;

import java.io.IOException;
import java.util.Scanner;

import model.Greetings;
import service.Menu;
import service.UserService;

public class UserController {
    public void user() throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        UserService userService = new UserService();
        Greetings greetings = new Greetings();
        while (true) {
            menu.userMenu();
            greetings.enter();
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.println(
                            "                                                                  =========================================== ");
                    System.out.println(
                            "                                                                    ||             1.LOGIN             ||");
                    System.out.println(
                            "                                                                    ||             2.REGISTER          ||");
                    System.out.println(
                            "                                                                  =========================================== ");
                    greetings.enter();

                    /* ----------------------------------------------- */

                    int choose = sc.nextInt();
                    switch (choose) {
                        case 1:
                            break;

                        case 2:
                            userService.registerUser();
                            break;

                        default:
                            break;
                    }

                    break;

                default:
                    break;
            }
        }
    }
}
