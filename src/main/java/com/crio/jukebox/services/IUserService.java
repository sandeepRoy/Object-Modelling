package com.crio.jukebox.services;

import com.crio.jukebox.entities.User;

import java.util.*;
public interface IUserService {
    List<User> getAllUsers();
    User createUser(String userName);
}
