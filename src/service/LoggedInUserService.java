package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import data.SongList;
import model.Greetings;
import model.Playlist;
import model.Song;
import model.User;

class Node {
    Node next, prev;
    Song song;

    Node(Song song) {
        this.song = song;
    }

    public static Node initializeSongDLL(ArrayList<Song> list) {
        if (list == null || list.isEmpty())
            return null;

        Node head = new Node(list.get(0));
        Node tail = head;

        for (int i = 1; i < list.size(); i++) {
            Node newNode = new Node(list.get(i));
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        tail.next = head;
        head.prev = tail;

        return head;
    }
}

public class LoggedInUserService {
    SongList songList = new SongList();
    Scanner sc = new Scanner(System.in);
    Greetings greetings = new Greetings();
    Node head = new Node(null);

    public void playSongs() throws FileNotFoundException {
        songList.loadsongList();
        ArrayList<Song> list = songList.getSongList();

        Node current = Node.initializeSongDLL(list);
        if (current == null)
            return;

        String padding = " ".repeat(67);
        while (true) {
            Song s = current.song;

            System.out.println(padding + "------------------------------------");
            System.out.printf(padding + "| Name:- %-27s |%n", s.getTitle());
            System.out.printf(padding + "| Duration:- %-21s  |%n",
                    String.valueOf(s.getDuration()).substring(0, 3) + "s");
            System.out.printf(padding + "| Views:- %-26s |%n", s.getViews());
            System.out.printf(padding + "| Views:- %-26s |%n", "(X)BACK");
            System.out.println(padding + "------------------------------------");
            System.out.printf(padding + "(-)PREV %-20s (+)NEXT%n", "");

            char ch = sc.next().charAt(0);
            if (ch == '+') {
                current = current.next;
            } else if (ch == '-') {
                current = current.prev;
            } else {
                break;
            }
        }
    }

    public void appendSongToPlayList(User user) throws IOException {
        Playlist playlist = new Playlist();
        Greetings greetings = new Greetings();
        SongList songList = new SongList();
        String padding = " ".repeat(67);
        System.out.print(padding + "Enter Song Id:- ");

        int id = sc.nextInt();

        ArrayList<Song> songsList = new ArrayList<>();
        songList.loadsongList();
        songsList = songList.getSongList();

        Song s = new Song();

        // BINARY SEARCH

        boolean found = false;
        int l = 0;
        int h = songsList.size() - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            int midId = songsList.get(mid).getId();

            if (midId == id) {
                s = songsList.get(mid);
                found = true;
                break;
            }
            if (midId < id) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        if (found == false) {
            System.out.printf(padding + "  SONG NOT FOUND !! %-27s %");
        } else {
            playlist.pushToPlayList(user, s);
        }
    }
}