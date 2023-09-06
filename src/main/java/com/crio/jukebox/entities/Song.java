package com.crio.jukebox.entities;

import java.util.*;
public class Song extends ID{
    String name, genre, album, artist;
    List<String> associatedArtists;
    public Song(Song song){
        this(song.id, song.name, song.genre, song.album, song.artist, song.associatedArtists);
    }
    public Song(String id, String name, String genre, String album, String artist, List<String> associatedArtists) {
        this(name, genre, album, artist, associatedArtists);
        this.id = id;
    }
    public Song(String name, String genre, String album, String artist, List<String> associatedArtists) {
        this.name = name;
        this.genre = genre;
        this.album = album;
        this.artist = artist;
        this.associatedArtists = associatedArtists;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public List<String> getAssociatedArtists() {
        return associatedArtists;
    }
    public void setAssociatedArtists(List<String> associatedArtists) {
        this.associatedArtists = associatedArtists;
    }
}
