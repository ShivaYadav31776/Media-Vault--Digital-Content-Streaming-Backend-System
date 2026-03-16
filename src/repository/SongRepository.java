package repository;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Greetings;
import model.Song;
import model.User;

public class SongRepository {
    public void addSong(Song song) throws IOException, InterruptedException {
        File songsFile = new File(
                "D:\\DSA Project\\Media-Vault---Digital-Content-Streaming-Backend-System\\src\\data\\Songs.csv");
        if (!songsFile.exists()) {
            songsFile.createNewFile();
        }

        BufferedOutputStream bufferedOutputStreamSong = new BufferedOutputStream(
                new FileOutputStream(songsFile, true));

        int songId = song.getId();
        String songTitle = song.getTitle();
        double songDuration = song.getDuration();
        long songViews = 0;
        ArrayList<User> viewedUsers = new ArrayList<>();
        String songData = songId + "," + songTitle + "," + songDuration + "," + songViews + ","
                + ("USERS:-" + viewedUsers)
                + "\n";
                Greetings greetings =  new Greetings();
                greetings.load5s();; // ----> load 10s
                System.out.println();
        bufferedOutputStreamSong.write(songData.getBytes());
        bufferedOutputStreamSong.close();
        System.out.println(
                "                                                                           Added Successfully !!");
    }

    public void getAllSongs() throws FileNotFoundException {
        File songsFile = new File(
                "D:\\DSA Project\\Media-Vault---Digital-Content-Streaming-Backend-System\\src\\data\\Songs.csv");

        BufferedInputStream bufferedInputStreamSongs = new BufferedInputStream(new FileInputStream(songsFile));

        Scanner scanSongs = new Scanner(bufferedInputStreamSongs);

        while (scanSongs.hasNextLine()) {
            String song1 = scanSongs.nextLine();
            String song1DetailArray[] = song1.split(",");

            String padding = " ".repeat(45);
            String singlePadding = " ".repeat(63);

            if (scanSongs.hasNextLine()) {
                String song2 = scanSongs.nextLine();
                String[] song2DetailArray = song2.split(",");

                // PRINTING FORMATE COPIED FROM CHAT GPT

                System.out.println(
                        padding + "------------------------------------    ------------------------------------");
                System.out.printf(padding + "| %-34s |    | %-34s |%n", "", "");
                System.out.printf(padding + "| Name:- %-27s |    | Name:- %-27s |%n", song1DetailArray[1],
                        song2DetailArray[1]);
                System.out.printf(padding + "| %-34s |    | %-34s |%n", "", "");
                System.out.printf(padding + "| Duration:- %-23s |    | Duration:- %-23s |%n", song1DetailArray[2],
                        song2DetailArray[2]);
                System.out.printf(padding + "| %-34s |    | %-34s |%n", "", "");
                System.out.printf(padding + "| Id:- %-29s |    | Id:- %-29s |%n", song1DetailArray[0],
                        song2DetailArray[0]);
                System.out.printf(padding + "| %-34s |    | %-34s |%n", "", "");
                System.out.printf(padding + "| Views:- %-26s |    | Views:- %-26s |%n", song1DetailArray[3],
                        song2DetailArray[3]);
                System.out.printf(padding + "| %-34s |    | %-34s |%n", "", "");
                System.out.println(
                        padding + "------------------------------------    ------------------------------------");
            } else {
                System.out.println(singlePadding + "------------------------------------");
                System.out.printf(singlePadding + "| %-34s |%n", "");
                System.out.printf(singlePadding + "| Name:- %-27s |%n", song1DetailArray[1]);
                System.out.printf(singlePadding + "| %-34s |%n", "");
                System.out.printf(singlePadding + "| Duration:- %-23s |%n", song1DetailArray[2]);
                System.out.printf(singlePadding + "| %-34s |%n", "");
                System.out.printf(singlePadding + "| Id:- %-29s |%n", song1DetailArray[0]);
                System.out.printf(singlePadding + "| %-34s |%n", "");
                System.out.printf(singlePadding + "| Views:- %-26s |%n", song1DetailArray[3]);
                System.out.printf(singlePadding + "| %-34s |%n", "");
                System.out.println(singlePadding + "------------------------------------");
            }

        }

    }
}