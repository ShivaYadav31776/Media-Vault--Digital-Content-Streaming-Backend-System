package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import data.Nav;
import data.SongList;
import model.Greetings;
import model.Song;
import model.TrendingSongPriorityQ;
import repository.SongRepository;

public class AdminService {
    Scanner sc = new Scanner(System.in);
    SongRepository songRepository = new SongRepository();

    public void showAnalytics() throws InterruptedException, FileNotFoundException {
        int arr[] = { 500, 450, 300 };
        for (int i = 0; i < 3; i++) {
            System.out.print(
                    "                                                                       SONG " + (i + 1) + ": ");
            for (int j = 10; j < arr[i]; j = j + 10) {
                System.out.print("█");
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            System.out.println();
            Thread.sleep(100);
            System.out.println();
        }
        AdminService adminService = new AdminService();
        adminService.trendingTop3Songs();
    }

    public void addSong() throws IOException, InterruptedException {
        SongList songList = new SongList();
        songList.loadsongList();
        ArrayList<Song> list = new ArrayList<>();
        list = songList.getSongList();
        Song song = new Song();
        Thread.sleep(1000);
        song.setId((list.size() + 1));
        System.out.print("                                                                      Enter Song Title:-");
        String title = sc.nextLine();
        song.setTitle(title);
        System.out.print(
                "                                                                      Enter Song Duration(min):-");
        double duration = sc.nextDouble();
        song.setDuration(duration);
        songRepository.addSong(song);
    }

    public void showSongs() throws FileNotFoundException {
        songRepository.getAllSongs();
    }

    // ── updated: accepts username for Nav logging ──
    public void searchSong(String username) throws InterruptedException, FileNotFoundException {
        String padding = " ".repeat(67);
        System.out.printf(padding + "(1)BY ID %-20s (2)BY NAME%n", "");
        System.out.print("                                                                   Enter:-");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                searchById(username);
                break;
            case 2:
                searchByName(username);
                break;
            default:
                break;
        }
    }

    public static void searchById(String username) throws InterruptedException, FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        SongList songList = new SongList();
        Greetings greetings = new Greetings();
        songList.loadsongList();
        ArrayList<Song> list = songList.getSongList();
        System.out.print(
                "                                                                      Enter Id:-");
        int searchId = sc.nextInt();

        int l = 0;
        int h = list.size() - 1;

        if (list.isEmpty()) {
            greetings.load10s();
            String padding = " ".repeat(67);
            System.out.printf(padding + "SORRY SONG IS NOT AVAILABLE %-20s %n", "");
            return;
        }

        Song foundSong = null;

        while (l <= h) {
            int mid = (l + h) / 2;
            if (list.get(mid).getId() == searchId) {
                foundSong = list.get(mid);
                break;
            } else if (list.get(mid).getId() > searchId) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (foundSong == null) {
            greetings.load5s();
            String padding = " ".repeat(67);
            System.out.printf(padding + "SORRY SONG IS NOT AVAILABLE %-20s %n", "");
            return;
        }

        // ── log found song ──
        Nav.log(username, "Searched by ID: " + foundSong.getTitle());

        String singlePadding = " ".repeat(67);
        System.out.println(singlePadding + "------------------------------------");
        System.out.printf(singlePadding + "| %-34s |%n", "");
        System.out.printf(singlePadding + "| Name:- %-27s |%n", foundSong.getTitle());
        System.out.printf(singlePadding + "| %-34s |%n", "");
        System.out.printf(singlePadding + "| Duration:- %-23s |%n", foundSong.getDuration());
        System.out.printf(singlePadding + "| %-34s |%n", "");
        System.out.printf(singlePadding + "| Id:- %-29s |%n", foundSong.getId());
        System.out.printf(singlePadding + "| %-34s |%n", "");
        System.out.printf(singlePadding + "| Views:- %-26s |%n", foundSong.getViews());
        System.out.printf(singlePadding + "| %-34s |%n", "");
        System.out.println(singlePadding + "------------------------------------");
    }

    public static void searchByName(String username) throws FileNotFoundException {
        SongList songList = new SongList();
        ArrayList<Song> list = new ArrayList<>();
        songList.loadsongList();
        list = songList.getSongList();
        Scanner sc = new Scanner(System.in);
        System.out.print(
                "                                                                      Enter Song Name:-");
        String searchName = sc.next().trim();

        if (list.size() == 0) {
            String padding = " ".repeat(67);
            System.out.printf(padding + "SORRY SONG IS NOT AVAILABLE %-20s %n", "");
            return;
        }

        Song foundSong = null;

        for (int i = 0; i < list.size(); i++) {
            if (searchName.equalsIgnoreCase(list.get(i).getTitle())) {
                foundSong = list.get(i);
                break;
            }
        }

        if (foundSong == null) {
            String padding = " ".repeat(67);
            System.out.printf(padding + "SORRY SONG IS NOT AVAILABLE %-20s %n", "");
            return;
        }

        // ── log found song ──
        Nav.log(username, "Searched by Name: " + foundSong.getTitle());

        String singlePadding = " ".repeat(67);
        System.out.println(singlePadding + "------------------------------------");
        System.out.printf(singlePadding + "| %-34s |%n", "");
        System.out.printf(singlePadding + "| Name:- %-27s |%n", foundSong.getTitle());
        System.out.printf(singlePadding + "| %-34s |%n", "");
        System.out.printf(singlePadding + "| Duration:- %-23s |%n", foundSong.getDuration());
        System.out.printf(singlePadding + "| %-34s |%n", "");
        System.out.printf(singlePadding + "| Id:- %-29s |%n", foundSong.getId());
        System.out.printf(singlePadding + "| %-34s |%n", "");
        System.out.printf(singlePadding + "| Views:- %-26s |%n", foundSong.getViews());
        System.out.printf(singlePadding + "| %-34s |%n", "");
        System.out.println(singlePadding + "------------------------------------");
    }

    public void trendingTop3Songs() throws FileNotFoundException {
        TrendingSongPriorityQ q = new TrendingSongPriorityQ();
        q.initQ();
        ArrayList<Song> top3 = new ArrayList<>();
        top3 = q.getTop3TrendingSongs();

        int i = 0;
        while (i < top3.size()) {
            String padding = " ".repeat(45);
            String singlePadding = " ".repeat(63);

            if (i + 1 < top3.size()) {
                System.out.println(
                        padding + "------------------------------------    ------------------------------------");
                System.out.printf(padding + "| %-34s |    | %-34s |%n", "", "");
                System.out.printf(padding + "| Name:- %-27s |    | Name:- %-27s |%n",
                        top3.get(i).getTitle(), top3.get(i + 1).getTitle());
                System.out.printf(padding + "| %-34s |    | %-34s |%n", "", "");
                System.out.printf(padding + "| Duration:- %-23s |    | Duration:- %-23s |%n",
                        top3.get(i).getDuration(), top3.get(i + 1).getDuration());
                System.out.printf(padding + "| %-34s |    | %-34s |%n", "", "");
                System.out.printf(padding + "| Id:- %-29s |    | Id:- %-29s |%n",
                        top3.get(i).getId(), top3.get(i + 1).getId());
                System.out.printf(padding + "| %-34s |    | %-34s |%n", "", "");
                System.out.printf(padding + "| Views:- %-26s |    | Views:- %-26s |%n",
                        top3.get(i).getViews(), top3.get(i + 1).getViews());
                System.out.printf(padding + "| %-34s |    | %-34s |%n", "", "");
                System.out.println(
                        padding + "------------------------------------    ------------------------------------");
                i += 2;
            } else {
                System.out.println(singlePadding + "------------------------------------");
                System.out.printf(singlePadding + "| %-34s |%n", "");
                System.out.printf(singlePadding + "| Name:- %-27s |%n", top3.get(i).getTitle());
                System.out.printf(singlePadding + "| %-34s |%n", "");
                System.out.printf(singlePadding + "| Duration:- %-23s |%n", top3.get(i).getDuration());
                System.out.printf(singlePadding + "| %-34s |%n", "");
                System.out.printf(singlePadding + "| Id:- %-29s |%n", top3.get(i).getId());
                System.out.printf(singlePadding + "| %-34s |%n", "");
                System.out.printf(singlePadding + "| Views:- %-26s |%n", top3.get(i).getViews());
                System.out.printf(singlePadding + "| %-34s |%n", "");
                System.out.println(singlePadding + "------------------------------------");
                i++;
            }
        }
    }
}