package service;

import java.io.IOException;
import java.util.Scanner;

import model.User;
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
}
