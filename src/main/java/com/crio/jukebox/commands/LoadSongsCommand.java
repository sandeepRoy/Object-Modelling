package com.crio.jukebox.commands;

import com.crio.jukebox.services.ISongService;

import java.util.List;

public class LoadSongsCommand implements ICommand{
    ISongService iSongService;

    public LoadSongsCommand(ISongService iSongService){
        this.iSongService = iSongService;
    }

    @Override
    public void execute(List<String> tokens) {
        try{
            String message = iSongService.loadSongs(tokens.get(1));
            System.out.println(message);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
