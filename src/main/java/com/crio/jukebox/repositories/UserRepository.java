package com.crio.jukebox.repositories;

import com.crio.jukebox.entities.User;

import java.util.*;
public class UserRepository implements IUserRepository {
    Integer autoIncrement;
    Map<String, User> userMap;

    public UserRepository(){
        this.userMap = new HashMap<String, User>();
        this.autoIncrement = 0;
    }

    public UserRepository(Map<String, User> userMap){
        this.userMap = userMap;
        this.autoIncrement = userMap.size();
    }

    @Override
    public User save(User entity) {
        if(entity.getId() == null){
            autoIncrement++;
            User user = new User(Integer.toString(autoIncrement), entity.getUserName());
            userMap.put(user.getId(), user);
            return user;
        }
        userMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public boolean existsById(String s) {
        return userMap.containsKey(s);
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public User findById(String id) {
        return userMap.getOrDefault(id, null);
    }
}
