package com.crio.jukebox.appconfig;

import com.crio.jukebox.commands.CommandInvoker;
import com.crio.jukebox.commands.CreateUserCommand;
import com.crio.jukebox.commands.LoadSongsCommand;

import com.crio.jukebox.repositories.ISongRepository;
import com.crio.jukebox.repositories.IUserRepository;
import com.crio.jukebox.repositories.SongRepository;
import com.crio.jukebox.repositories.UserRepository;
import com.crio.jukebox.services.ISongService;
import com.crio.jukebox.services.IUserService;
import com.crio.jukebox.services.SongService;
import com.crio.jukebox.services.UserService;

import java.util.List;

public class AppConfig {

    private final ISongRepository songRepository = new SongRepository();
    private final ISongService songService = new SongService(songRepository);
    private final LoadSongsCommand loadSongsCommand = new LoadSongsCommand(songService);

    private final IUserRepository userRepository = new UserRepository();
    private final IUserService userService = new UserService(userRepository);
    private final CreateUserCommand createUserCommand= new CreateUserCommand(userService);
    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("LOAD-DATA", loadSongsCommand);
        commandInvoker.register("CREATE-USER", createUserCommand);
        return commandInvoker;
    }

}