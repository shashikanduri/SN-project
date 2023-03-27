package com.sn.SNProject.services;

import com.sn.SNProject.dao.UserDao;
import com.sn.SNProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@Service
public class UserAccountService {
    private UserDao userDao;
    private DiffieHellman diffieHellman;
    @Autowired
    public UserAccountService(@Qualifier("userdaoaccess") UserDao userDao, DiffieHellman diffieHellman) {
        this.userDao = userDao;
        this.diffieHellman = diffieHellman;
    }
    public String addUser(User user){

        userDao.addUser(user);
        return "200";
    }

    public String sendPDSKey() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        return diffieHellman.sendPDSKey();
    }
}
