package com.sn.SNProject;

import com.sn.SNProject.services.DiffieHellman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@SpringBootApplication
public class SnProjectApplication {


	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, InvalidKeyException {
		SpringApplication.run(SnProjectApplication.class, args);
		//DiffieHellman diffieHellman = new DiffieHellman();
		//diffieHellman.generateSecretKey("OMAwgLn67EhxOygh83xSVrMGU0ey88ImHBsasoNjytM/n6g+jlsVNEOVlvIp7bxqVNgD6kGfHRkwxT/AK5bWgHobQ80GTiMSAp95lCnHb/3yAOOLHV6N8QQECbUlPK4A+8DqTppDEXTcET8W9wkxd1ecOth+Ty4empZLJKp3nU9ogJqFIDfZ1cVVRs3BGWIuTWxjYdD6+eXwZ1jub41NyhjAwAkAgwcHGZqdNWrSadIx70Lyb7tn28RbxV9DloJ4gYZkP4Vmdoddnwpwrf7oeWrchXOPqhqT+Jj8FMlh/oGZaUCcVGggCWn0AIqCYAHfjacjDy0mKKKg3hRTVyp4zdSumYV+GrdKf/z8LI8jMYKxMyU4GGcp1P00K0tht3rPWF096+gsPe/OnHaYpzG8bEfbJOX9ynZVj/pgCghyd7M46FTXZjcJMc3oeDuaJdyrkbym7uJri1jrMoVrBpcX5NPovnrGkPWVciWQrHerTQ31E3ZMtPzuckpahabUwXqH");
	}

}
