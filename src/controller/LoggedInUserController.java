package controller;

import java.io.IOException;
import java.util.Scanner;

import data.Nav;
import model.Greetings;
import model.User;
import service.AdminService;
import service.LoggedInUserService;
import service.Menu;
import service.UserService;

public class LoggedInUserController {
    Menu menu = new Menu();
    Scanner sc = new Scanner(System.in);
    Greetings greetings = new Greetings();
    AdminService adminService = new AdminService();
    LoggedInUserService loggedInUserService = new LoggedInUserService();
    UserService userService = new UserService();

    public void loggedInUser(User user) throws InterruptedException, IOException {
        while (true) {
            menu.LoggedInUser();
            greetings.enter();
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    Nav.log(user.getUserId(), "Opened Play Songs");
                    loggedInUserService.playSongs(user);
                    break;

                case 2:
                    Nav.log(user.getUserId(), "Opened Search");
                    adminService.searchSong(user.getUserId());
                    break;

                case 3:
                    Nav.log(user.getUserId(), "Viewed Trending Songs");
                    userService.trendingTop10Songs();
                    break;

                case 4:
                    Nav.log(user.getUserId(), "Viewed All Songs");
                    adminService.showSongs();
                    break;

                case 5:
                    Nav.log(user.getUserId(), "Added Song to Playlist");
                    loggedInUserService.appendSongToPlayList(user);
                    break;

                case 6:
                    Nav.display();
                    break;

                default:
                    Nav.log(user.getUserId(), "Logged out");
                    Nav.clear();
                    return;
            }
        }
    }
}