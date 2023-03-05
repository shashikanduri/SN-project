package com.sn.SNProject.dao;
import com.sn.SNProject.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void checkUser(User user);
    List<User> getAllUsers();
}
