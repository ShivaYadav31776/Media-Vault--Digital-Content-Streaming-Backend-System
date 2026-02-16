package model;

import java.util.ArrayList;

public class Song {
    int id;
    String title;
    double duration;
    long views;
    ArrayList<User> viewedUsers = new ArrayList<>();
}
