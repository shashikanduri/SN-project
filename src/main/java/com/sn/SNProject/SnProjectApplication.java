package com.sn.SNProject;

import com.sn.SNProject.services.DiffieHellman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@SpringBootApplication
public class SnProjectApplication {


	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, InvalidKeyException {

		SpringApplication.run(SnProjectApplication.class, args);
		DiffieHellman diffieHellman = new DiffieHellman();
		String a = "-----BEGIN PUBLIC KEY-----" +
				"BlWdCWcsVzjNOUidP3hXT/kVrLbuTifYgJMXFL+zyGs="+
				"-----END PUBLIC KEY-----";
		diffieHellman.generateSecretKey(a);
	}

}
