package com.crio.jukebox.repositories;

import com.crio.jukebox.entities.Song;

import java.util.*;

public class SongRepository implements ISongRepository {
    private Integer autoIncrement;
    private final Map<String, Song> songMap;

    public SongRepository(){
        this.songMap = new HashMap<String, Song>();
        this.autoIncrement = 0;
    }

    public SongRepository(Map<String, Song> songMap){
        this.songMap = songMap;
        this.autoIncrement = songMap.size();
    }

    @Override
    public Song save(Song entity) {
        if(entity.getId() == null){
            autoIncrement++;
            Song song = new Song(Integer.toString(autoIncrement), entity.getName(), entity.getGenre(), entity.getAlbum(), entity.getArtist(), entity.getAssociatedArtists());
            songMap.put(song.getId(), song);
            return song;
        }
        songMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public List<Song> findAll() {
        return new ArrayList<>(songMap.values());
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void delete(Song entity) {

    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Song findById(String id) {
        return songMap.getOrDefault(id, null);
    }
}
