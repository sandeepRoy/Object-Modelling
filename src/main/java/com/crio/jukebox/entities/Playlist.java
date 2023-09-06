package com.crio.jukebox.entities;

import java.util.*;

public class Playlist extends ID {
    String playlistName;
    User creator;
    List<String> songs;

    public Playlist(Playlist playlist){
        this(playlist.getId(), playlist.getPlaylistName(), playlist.getCreator(), playlist.getSongs());
    }
    public Playlist(String playlistName, User creator, List<String> songs) {
        this.playlistName = playlistName;
        this.creator = creator;
        this.songs = songs;
    }
    public Playlist(String id, String playlistName, User creator, List<String> songs){
        this(playlistName, creator, songs);
        this.id = id;
    }

    public void addSong(String songId){
        if(!hasSong(songId)){
            this.songs.add(songId);
        }
    }

    private boolean hasSong(String songId) {
        return this.songs.remove(songId);
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }
}
