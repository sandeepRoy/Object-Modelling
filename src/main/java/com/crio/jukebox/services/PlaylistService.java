package com.crio.jukebox.services;

import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.repositories.IPlaylistRepository;
import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.repositories.IUserRepository;

import java.util.*;
public class PlaylistService {
    IPlaylistRepository iPlaylistRepository;
    IUserRepository iUserRepository;
    ISongRepository iSongRepository;
}
