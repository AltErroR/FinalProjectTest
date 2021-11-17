package com.my.dao;

import com.my.entity.User;

import java.util.List;

public interface UserDao {
    boolean createUser(int id);
    boolean updateUser(int id,int wallet);
    User getUser(int id);
    boolean deleteUser(int id);
    List<User> getAllUsers();
}
