package com.crio.jukebox.services;

import com.crio.jukebox.entities.Playlist;

import java.util.*;

public interface IPlaylistService {
    Playlist createPlaylist(String userID, String playlistName, List<String> songIDs);
    Playlist deletePlaylist(String userID, String playlistID);
    Playlist modifyPlaylist(String actionCommand, String userID, String playlistID, List<String> songIDs);
    boolean validateSongIDs(List<String> songIDs);
}
