package com.crio.jukebox.commands;

import com.crio.jukebox.entities.User;
import com.crio.jukebox.services.IUserService;

import java.util.List;

public class CreateUserCommand implements ICommand {
    public IUserService iUserService;

    public CreateUserCommand(IUserService iUserService){
        this.iUserService = iUserService;
    }

    @Override
    public void execute(List<String> tokens) {
        User user = iUserService.createUser(tokens.get(1));
        System.out.println(user.getId() + " " + user.getUserName());
    }
}
