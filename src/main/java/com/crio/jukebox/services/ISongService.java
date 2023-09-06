package com.crio.jukebox.services;

import com.crio.jukebox.entities.Song;

import java.io.IOException;
import java.util.*;

public interface ISongService {
    List<Song> getAllSongs();
    Song getSongById(String id);
    String loadSongs(String file) throws IOException;
}
