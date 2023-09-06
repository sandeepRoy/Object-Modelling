package com.crio.jukebox.services;

import com.crio.jukebox.entities.User;
import com.crio.jukebox.repositories.IUserRepository;

import java.util.List;

public class UserService implements IUserService{
    public IUserRepository iUserRepository;
    public UserService(IUserRepository iUserRepository){
        this.iUserRepository = iUserRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return iUserRepository.findAll();
    }

    @Override
    public User createUser(String userName) {
        if(userName.isEmpty()){
            return null;
        }
        return iUserRepository.save(new User(userName));
    }
}
