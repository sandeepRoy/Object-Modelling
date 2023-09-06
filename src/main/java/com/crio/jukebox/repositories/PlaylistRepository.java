package com.crio.jukebox.repositories;

import com.crio.jukebox.entities.Playlist;

import java.util.*;
public class PlaylistRepository implements IPlaylistRepository {
    Integer autoIncrement;
    Map<String, Playlist> playlistMap;

    public PlaylistRepository(){
        this.playlistMap = new HashMap<String, Playlist>();
        this.autoIncrement = 0;
    }
    public PlaylistRepository(Map<String, Playlist> playlistMap){
        this.playlistMap = playlistMap;
        this.autoIncrement = playlistMap.size();
    }
    @Override
    public Playlist save(Playlist entity) {
        if(entity.getId() == null){
            autoIncrement++;
            Playlist playlist = new Playlist(Integer.toString(autoIncrement), entity.getPlaylistName(), entity.getCreator(), entity.getSongs());
            playlistMap.put(playlist.getId(), playlist);
            return playlist;
        }
        playlistMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public List<Playlist> findAll() {
        return new ArrayList<>(playlistMap.values());
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void delete(Playlist entity) {
        this.deleteById(entity.getId());
    }

    @Override
    public void deleteById(String s) {
        this.playlistMap.remove(s);
    }

    @Override
    public long count() {
        return playlistMap.size();
    }

    @Override
    public Playlist findById(String id) {
        return this.playlistMap.get(id);
    }
}
