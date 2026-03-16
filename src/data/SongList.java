package data;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Song;

public class SongList {
    public ArrayList<Song> songlist = new ArrayList<>();

    public ArrayList<Song> getSongList() {
        return songlist;
    }

    public void loadsongList() throws FileNotFoundException {
        File songsFile = new File(
                "D:\\DSA Project\\Media-Vault---Digital-Content-Streaming-Backend-System\\src\\data\\Songs.csv");

        BufferedInputStream bufferedInputStreamSongs = new BufferedInputStream(new FileInputStream(songsFile));

        Scanner scanSongs = new Scanner(bufferedInputStreamSongs);

        while (scanSongs.hasNextLine()) {
            String song1 = scanSongs.nextLine();
            String song1DetailArray[] = song1.split(",");

            Song song = new Song();

            song.setId(Integer.parseInt(song1DetailArray[0]));
            song.setTitle(song1DetailArray[1]);
            song.setDuration(Float.parseFloat(song1DetailArray[2]));
            song.setViews(Long.parseLong(song1DetailArray[3]));

            songlist.add(song);
        }
    }
}
