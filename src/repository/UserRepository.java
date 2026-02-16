package repository;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import model.User;

public class UserRepository {
    public void addUser(User user) throws IOException {
        File usersFile = new File(
                "D:/Projects/Core JAVA/Media Vault - Digital Content & Streaming Backend System/Program/src/data/Users.csv");
        if (!usersFile.exists()) {
            usersFile.createNewFile();
        }

        BufferedOutputStream bufferedOutputStreamUsers = new BufferedOutputStream(
                new FileOutputStream(usersFile, true));

        String userId = user.getUserId();
        String userName = user.getName();
        long userPhone = user.getPhone();
        String userEmail = user.getEmail();
        String userPassword = user.getPassword();

        String userData = userId + "," + userName + "," + userPhone + "," + userEmail + "," + userPassword + "\n";
        bufferedOutputStreamUsers.write(userData.getBytes());
        bufferedOutputStreamUsers.close();
    }
}
