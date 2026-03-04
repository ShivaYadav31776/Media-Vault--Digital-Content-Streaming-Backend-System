package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import data.UserList;
import model.User;
import repository.SongRepository;
import repository.UserRepository;

public class UserService {

        public void registerUser() throws IOException {
                User newUser = new User();
                UserRepository userRepository = new UserRepository();
                Scanner sc = new Scanner(System.in);
                // ========================user inputs======================

                System.out.print(
                                "                                                                     ## Enter Name {Eg:Abhishek}:- ");
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
                                "                                                                     ## Enter Email {Eg:avi@gamil.com}:- ");
                String email = sc.next();
                if (email.endsWith(".com")) {
                        newUser.setEmail(email);
                } else {
                        System.out.println(
                                        "                                                                                Invalid Email");
                        return;
                }

                System.out.print(
                                "                                                                     ## Set Password{Eg:avi2025}:- ");
                newUser.setPassword(sc.next());

                System.out.print(
                                "                                                                     ## Set Id {Eg:avi_2025}:- ");
                newUser.setUserId(sc.next());
                System.out.println();
                System.out.println(
                                "                                                                                Registration Done");

                userRepository.addUser(newUser);

        }

        public void showSongs() throws FileNotFoundException {
                SongRepository songRepository = new SongRepository();
                songRepository.getAllSongs();
        }

        public void login() throws FileNotFoundException {
                Scanner sc = new Scanner(System.in);
                UserList userList = new UserList();
                userList.loadUserList();
                ArrayList<User> list = userList.getUserList();
                System.out.print(
                                "                                                                     ## Enter Email {Eg:avi@gamil.com}:- ");
                String enteredEmail = sc.next();
                System.out.print(
                                "                                                                     ## Set Password{Eg:avi2025}:- ");
                String enteredPassword = sc.next();
                int l = 0;
                int h = list.size();

                while (l < h) {
                        if (list.get(l).getEmail().equals(enteredEmail)
                                        && list.get(l).getPassword().equals(enteredPassword)) {
                                System.out.println();
                                System.out.print(
                                                "                                                                           LOGGED IN SUCCESSFULLY ");
                                return;
                        }
                        l++;
                }

                System.out.print(
                                "                                                                     INVALID USER !! ");
        }
}
