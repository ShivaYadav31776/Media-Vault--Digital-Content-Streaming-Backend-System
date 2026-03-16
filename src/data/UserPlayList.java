package data;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserPlayList {
    public ArrayList<XyzUser> userlist = new ArrayList<>();

    public void loadUserPlayList() throws FileNotFoundException {
        userlist.clear();

        File songsFile = new File(
                "D:\\DSA Project\\Media-Vault---Digital-Content-Streaming-Backend-System\\src\\data\\UserPlaylist.csv");

        if (!songsFile.exists() || songsFile.length() == 0) {
            return;
        }

        Scanner scanUsers = new Scanner(new BufferedInputStream(new FileInputStream(songsFile)));

        while (scanUsers.hasNextLine()) {
            String line = scanUsers.nextLine();
            if (line.trim().isEmpty())
                continue;

            String[] userDetailArray = line.split(",");
            if (userDetailArray.length < 2)
                continue;

            XyzUser userr = new XyzUser();
            userr.setUserId(userDetailArray[0]);
            userr.setEmail(userDetailArray[1]);

            ArrayList<Integer> playListSongs = new ArrayList<>();

            if (userDetailArray.length > 2 && !userDetailArray[2].isEmpty()) {
                String[] ids = userDetailArray[2].split(";");
                for (String id : ids) {
                    if (!id.trim().isEmpty()) {
                        playListSongs.add(Integer.parseInt(id.trim()));
                    }
                }
            }

            userr.setPlaylistSongs(playListSongs);
            userlist.add(userr);
        }
        scanUsers.close();
    }

    public ArrayList<XyzUser> getUserPlayList() {
        return userlist;
    }
}