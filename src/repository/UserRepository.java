package repository;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import data.UserList;
import data.UserPlayList;
import data.XyzUser;
import model.Song;
import model.User;

public class UserRepository {
    UserList userList = new UserList();

    public void addUser(User user) throws IOException {
        UserList userList = new UserList();
        userList.loadUserList();
        ArrayList<User> list = userList.getUserList();
        File usersFile = new File(
                "D:\\DSA Project\\Media-Vault---Digital-Content-Streaming-Backend-System\\src\\data\\Users.csv");

        if (!usersFile.exists()) {
            usersFile.createNewFile();
        }

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(usersFile, true));

        int uniqueId = list.size() + 1;
        String userId = user.getUserId();
        String userName = user.getName();
        long userPhone = user.getPhone();
        String userEmail = user.getEmail();
        String userPassword = user.getPassword();
        ArrayList playedSongs = user.getPlayedSongs();
        String subscriptionName = user.getSubscription().getSubscriptionName();

        String subscriptionActive = (!subscriptionName.equalsIgnoreCase("NA")) ? "TRUE" : "FALSE";
        String subscriptionPrice = String.valueOf(user.getSubscription().getPrice());

        String userData = uniqueId + "," + userId + "," + userName + "," + userPhone + "," + userEmail + ","
                + userPassword + "," + subscriptionActive + "," + subscriptionName + ","
                + subscriptionPrice + "," + playedSongs + "\n";

        bos.write(userData.getBytes());
        bos.close();
    }

    public void addSongToPlayList(String userEmail, Song song) throws IOException {
        UserPlayList userPlayList = new UserPlayList();
        userPlayList.loadUserPlayList();
        ArrayList<XyzUser> users = userPlayList.getUserPlayList();

        boolean found = false;
        for (XyzUser u : users) {
            if (u.getEmail().equalsIgnoreCase(userEmail)) {
                u.getPlaylistSongs().add(song.getId());
                found = true;
                break;
            }
        }

        if (!found) {
            XyzUser newUser = new XyzUser();
            newUser.setUserId("U" + (users.size() + 101));
            newUser.setEmail(userEmail);
            ArrayList<Integer> newSongList = new ArrayList<>();
            newSongList.add(song.getId());
            newUser.setPlaylistSongs(newSongList);
            users.add(newUser);
        }

        File usersFile = new File(
                "D:\\DSA Project\\Media-Vault---Digital-Content-Streaming-Backend-System\\src\\data\\UserPlaylist.csv");

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(usersFile, false))) {
            for (XyzUser u : users) {
                StringBuilder songIds = new StringBuilder();
                ArrayList<Integer> songs = u.getPlaylistSongs();

                for (int i = 0; i < songs.size(); i++) {
                    songIds.append(songs.get(i));
                    if (i < songs.size() - 1) {
                        songIds.append(";");
                    }
                }

                String data = u.getUserId() + "," + u.getEmail() + "," + songIds.toString() + "\n";
                bos.write(data.getBytes());
            }
        }
    }
}