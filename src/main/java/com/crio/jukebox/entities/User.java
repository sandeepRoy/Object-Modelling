package com.crio.jukebox.entities;

import java.util.*;

public class User extends ID{
    String userName;
    List<String> playlist;

    public User(User user){
        this(user.getId(), user.getUserName(), user.getPlaylist());
    }

    public User(String id, String name){
        this(name);
        this.id = id;
    }
    public User(String id, String name, List<String> playlist){
        this.id = id;
        this.userName = name;
        this.playlist = playlist;
    }
    public User(String name){
        this.userName = name;
        this.playlist = new ArrayList<String>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<String> playlist) {
        this.playlist = playlist;
    }

    public boolean hasPlaylist(String id){
        return this.playlist.contains(id);
    }

    public void removePlaylist(String id){
        this.playlist.remove(id);
    }
}
