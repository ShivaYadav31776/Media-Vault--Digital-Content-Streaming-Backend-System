package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.LoggedInUserController;
import data.Nav;
import data.UserList;
import model.Greetings;
import model.Song;
import model.TrendingSongPriorityQ;
import model.User;
import repository.SongRepository;
import repository.UserRepository;

public class UserService {

        public void registerUser() throws IOException {
                User newUser = new User();
                UserRepository userRepository = new UserRepository();
                Scanner sc = new Scanner(System.in);

                System.out.print(
                                "                                                                     ## Enter Name {Eg:Tun Tun Mosi}:- ");
                newUser.setName(sc.nextLine());
                System.out.print(
                                "                                                                     ## Enter Phone {Eg:89452XXXX}:- ");
                long phone = sc.nextLong();
                if (String.valueOf(phone).length() != 10) {
                        System.out.println(
                                        "                                                                                Invalid Phone");
                        return;
                } else {
                        newUser.setPhone(phone);
                }

                System.out.print(
                                "                                                                     ## Enter Email {Eg:email@gamil.com}:- ");
                String email = sc.next();
                if (email.endsWith(".com")) {
                        newUser.setEmail(email);
                } else {
                        System.out.println(
                                        "                                                                                Invalid Email");
                        return;
                }

                System.out.print(
                                "                                                                     ## Set Password{Eg:user2025}:- ");
                newUser.setPassword(sc.next());

                System.out.print(
                                "                                                                     ## Set Id {Eg:user_2025}:- ");
                newUser.setUserId(sc.next());
                System.out.println();
                System.out.println(
                                "                                                                                Registration Done");
                model.Subscription subscription = new model.Subscription();
                subscription.setActive(false);
                subscription.setSubscriptionName("NA");
                subscription.setPrice(0);
                newUser.setSubscription(subscription);
                userRepository.addUser(newUser);
        }

        public void showSongs() throws FileNotFoundException {
                SongRepository songRepository = new SongRepository();
                songRepository.getAllSongs();
        }

        public void login() throws InterruptedException, IOException {
                LoggedInUserController loggedInUserController = new LoggedInUserController();
                Greetings greetings = new Greetings();
                Scanner sc = new Scanner(System.in);
                UserList userList = new UserList();
                userList.loadUserList();
                ArrayList<User> list = userList.getUserList();

                System.out.print(
                                "                                                                     ## Enter Email {Eg:user@gamil.com}:- ");
                String enteredEmail = sc.next();
                System.out.print(
                                "                                                                     ## Set Password{Eg:user2025}:- ");
                String enteredPassword = sc.next();

                int l = 0;
                int h = list.size();

                while (l < h) {
                        if (list.get(l).getEmail().equals(enteredEmail)
                                        && list.get(l).getPassword().equals(enteredPassword)) {

                                User loggedUser = list.get(l);

                                // ── NAV: load past history + log login ──
                                Nav.load(loggedUser.getUserId());  // ← yahi change hai
                                Nav.log(loggedUser.getUserId(), "Logged in");

                                System.out.println();
                                System.out.println(
                                                "                                                                           LOGGED IN SUCCESSFULLY ");
                                greetings.welcomeToLoggedInUser(loggedUser.getName(), loggedUser.getUserId());
                                loggedInUserController.loggedInUser(loggedUser);
                                return;
                        }
                        l++;
                }

                System.out.print(
                                "                                                                     INVALID USER !! ");
        }

        public void trendingTop10Songs() throws FileNotFoundException {
                TrendingSongPriorityQ q = new TrendingSongPriorityQ();
                q.initQ();
                ArrayList<Song> top10 = new ArrayList<>();
                top10 = q.getTop10TrendingSongs();

                int i = 0;
                while (i < top10.size()) {
                        String padding = " ".repeat(45);
                        String singlePadding = " ".repeat(63);

                        if (i + 1 < top10.size()) {
                                System.out.println(
                                                padding + "------------------------------------    ------------------------------------");
                                System.out.printf(padding + "| %-34s |    | %-34s |%n", "", "");
                                System.out.printf(padding + "| Name:- %-27s |    | Name:- %-27s |%n",
                                                top10.get(i).getTitle(), top10.get(i + 1).getTitle());
                                System.out.printf(padding + "| %-34s |    | %-34s |%n", "", "");
                                System.out.printf(padding + "| Duration:- %-23s |    | Duration:- %-23s |%n",
                                                top10.get(i).getDuration(), top10.get(i + 1).getDuration());
                                System.out.printf(padding + "| %-34s |    | %-34s |%n", "", "");
                                System.out.printf(padding + "| Id:- %-29s |    | Id:- %-29s |%n",
                                                top10.get(i).getId(), top10.get(i + 1).getId());
                                System.out.printf(padding + "| %-34s |    | %-34s |%n", "", "");
                                System.out.printf(padding + "| Views:- %-26s |    | Views:- %-26s |%n",
                                                top10.get(i).getViews(), top10.get(i + 1).getViews());
                                System.out.printf(padding + "| %-34s |    | %-34s |%n", "", "");
                                System.out.println(
                                                padding + "------------------------------------    ------------------------------------");
                                i += 2;
                        } else {
                                System.out.println(singlePadding + "------------------------------------");
                                System.out.printf(singlePadding + "| %-34s |%n", "");
                                System.out.printf(singlePadding + "| Name:- %-27s |%n", top10.get(i).getTitle());
                                System.out.printf(singlePadding + "| %-34s |%n", "");
                                System.out.printf(singlePadding + "| Duration:- %-23s |%n", top10.get(i).getDuration());
                                System.out.printf(singlePadding + "| %-34s |%n", "");
                                System.out.printf(singlePadding + "| Id:- %-29s |%n", top10.get(i).getId());
                                System.out.printf(singlePadding + "| %-34s |%n", "");
                                System.out.printf(singlePadding + "| Views:- %-26s |%n", top10.get(i).getViews());
                                System.out.printf(singlePadding + "| %-34s |%n", "");
                                System.out.println(singlePadding + "------------------------------------");
                                i++;
                        }
                }
        }
}