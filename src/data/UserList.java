package data;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.User;

public class UserList {
    public ArrayList<User> userlist = new ArrayList<>();

    public void loadUserList() throws FileNotFoundException {
        File songsFile = new File(
                "D:\\DSA Project\\Media-Vault---Digital-Content-Streaming-Backend-System\\src\\data\\Users.csv");

        BufferedInputStream bufferedInputStreamSongs = new BufferedInputStream(new FileInputStream(songsFile));

        Scanner scanUsers = new Scanner(bufferedInputStreamSongs);

        while (scanUsers.hasNextLine()) {
            String user = scanUsers.nextLine();
            String userDetailArray[] = user.split(",");

            User xyzUser = new User();
            xyzUser.setUserId(userDetailArray[1]);
            xyzUser.setName(userDetailArray[2]);
            xyzUser.setEmail(userDetailArray[4]);
            xyzUser.setPhone(Long.parseLong(userDetailArray[3]));
            xyzUser.setPassword(userDetailArray[5]);

            userlist.add(xyzUser);
        }
    }

    public ArrayList<User> getUserList() {
        return userlist;
    }

}
