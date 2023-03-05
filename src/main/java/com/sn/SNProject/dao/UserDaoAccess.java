package com.sn.SNProject.dao;

import com.sn.SNProject.model.User;
import com.sn.SNProject.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("userdaoaccess")
public class UserDaoAccess implements UserDao{
    @Autowired
    UsersRepository userRepository;
    List<User> users = new ArrayList<User>();
    @Override
    public void addUser(User user) {
        userRepository.insert(user);
    }

    @Override
    public void checkUser(User user) {

    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
