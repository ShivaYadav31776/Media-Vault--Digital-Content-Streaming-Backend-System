import java.io.IOException;
import java.util.Scanner;

import controller.AdminController;
import controller.UserController;
import model.Greetings;
import service.Menu;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        // IMPORTS
        Greetings greetings = new Greetings();
        Menu menu = new Menu();
        AdminController adminController = new AdminController();
        UserController userController = new UserController();
        Scanner sc = new Scanner(System.in);

        // LOGICS
        while (true) {
            greetings.welcome();
            greetings.enter();
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    userController.user();
                    break;

                case 2:
                    adminController.admin();
                    break;

                default: {
                    System.out.println(
                            "                                                                           THANK's (EXITED)");
                    System.exit(input);
                    break;
                }
            }
        }
    }
}