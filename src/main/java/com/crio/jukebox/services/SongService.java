package com.crio.jukebox.services;

import com.crio.jukebox.entities.Song;
import com.crio.jukebox.repositories.ISongRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SongService implements ISongService {
    public ISongRepository iSongRepository;
    public SongService(ISongRepository iSongRepository){
        this.iSongRepository = iSongRepository;
    }

    @Override
    public List<Song> getAllSongs() {
        return new ArrayList<>(iSongRepository.findAll());
    }

    @Override
    public Song getSongById(String id) {
        return iSongRepository.findById(id);
    }

    @Override
    public String loadSongs(String file) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] values = line.split(",");
                if(values.length >= 5){
                    String name = values[0].trim();
                    String genre = values[1].trim();
                    String album = values[2].trim();
                    String artist = values[3].trim();
                    String associatedArtistsString = values[4].trim();
                    List<String> associatedArtists = create_list_associatedArtists(associatedArtistsString);
                    Song song = new Song(name, genre, album, artist, associatedArtists);
                    iSongRepository.save(song);
                }
            }
        }
        return "Songs Loaded Successfully";
    }

    private List<String> create_list_associatedArtists(String associatedArtistsString) {
        String[] data = associatedArtistsString.split("#");
        return Arrays.asList(data);
    }
}
