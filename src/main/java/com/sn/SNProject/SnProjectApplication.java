package com.sn.SNProject;

import com.sn.SNProject.services.DiffieHellman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

@SpringBootApplication
public class SnProjectApplication {


	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, InvalidKeyException, SignatureException {
		SpringApplication.run(SnProjectApplication.class, args);
		DiffieHellman diffieHellman = new DiffieHellman();
		String sig = "LnCLuV5qUxWgMe1LE8lrMDqo2tRny6bL5DBhHoPEq5k0jwyp4P9MaFpJ/NtZJcC1XSPTWJQbWI9qGJHdkcM03M/jQ+7vl1izdPEPVgv+hVFwJJlZhHY60U8ZEM2WaDHTZbSxMFRaPgsYJFdF1Iq+0GrlCqOCPHVaw/fWy1aycdRAcK/rO90O3MRy9yIQxZXSCWADg3dkhhqyHAcup27maZPgzT03UAUEorbGXuo7R5AIfAPSPlA2G76Z9uDGSL6IEnOcywg8hO2uJju8eS/SqI6bvIZkEkQYPu8MEpRCk81gwKZoIgR0jib9qjPr+tTgkJoxHcFOhF/spaja55avXA==";
		String pkey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAj0zaPBdtaxEiWp6hVUP7" +
				"8R+TGOD+IbzilJJq3qrqSntMT4GI+2jcFNnRuWRYJVjPIu3hScbb/8m/pDeEGmBY" +
				"zMEFbWIXRc486wR7L6xOuX8utq+WZRwm5cmdIublNjd9qcUSWkxwecOibqf9ky6E" +
				"iYaZfHQO7erzqcvtmF8ul/8CmLi9GTyaKgbILRZDlPIlNtO/cLI5Cm/6pROue7Cg" +
				"jxDA3IWoNU0MbItNTeJjIxfz0MuEnnj8Pvk/QMmx3HhYLO0lQVYeKhPRKdWVz0AW" +
				"X7Ki0cS2x0m+hJFVbwimoiZpJgcgO+b31CwVr74vfoyaMLWSOUwM9TuhGSgpwzfo" +
				"FQIDAQAB";
		System.out.println(diffieHellman.verify("shashi",sig,pkey));
	}
}
