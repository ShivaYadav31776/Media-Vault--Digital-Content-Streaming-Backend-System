package model;

import java.util.ArrayList;

public class Song {
    public int id;
    String title;
    double duration;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }
    public long getViews() {
        return views;
    }
    public void setViews(long views) {
        this.views = views;
    }
    public ArrayList<User> getViewedUsers() {
        return viewedUsers;
    }
    public void setViewedUsers(ArrayList<User> viewedUsers) {
        this.viewedUsers = viewedUsers;
    }
    long views;
    ArrayList<User> viewedUsers = new ArrayList<>();
}
