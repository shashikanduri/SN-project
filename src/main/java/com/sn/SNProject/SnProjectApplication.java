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
		String sig = "SWs8ZGtJ94wAC2Ld8kICaJNeE+89DwBHZyej4d2JiqZ9c/l2d8cXL+MQXxkG7cjo2qbJB0z8QlcBTzagn2FQDVWrjB1d5/5BP35gl90c7j/9WIcNud2aO3qM2L5PtLfQPHCv+0jHYMAHARVIIGWfWgZ5HrkDTL+m06VxYx4MdUKaBjLVB1rk0AMXd3KXT3jpKq+uUdx6IW743/fhevn4iC3Ly30XesLh9TF3ty3hPXi/6n0gCAqxjthAkBJOQLdqRibVsFb/0IA48Pl+vgRoe0ra96E+iiuqkjEneWhunaxmgeD1FUWVNeNBnwnL+U6TRu1Dy88TI2z3j8WR2qQpsA==";
		String pkey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhSUL4GlXZarNU3B4Tmxh" +
				"x8X9LmG6XpbSGuscY8xswi0jKqgjPKWphJy1yZUBlcu1BkaQPpdDPcZneh4zMgPc" +
				"cVy3kzGWGHlPJAxgPlIXpc4Ffis+rq9p2MdjRPHLj0njMtbZiv54IjH9xmBkUuOp" +
				"u9eic/VKY6oBt8wweLCdnG/N4JoX+/3kg+z3yhq+qbLvKwYagVfYFMBS8zcdrmVE" +
				"VJnXgK9Jt9oVqch2HMDusz4ofdZJnh8U3brCVZ0SzxhXYBYHw6KzWgcKtwgV9twz" +
				"XUoihcmHILYnJ0XOqSX6X+hHeX6Az6Mm2bI41Pi4wavvXkR0kPBBGo0IRCx7jvba" +
				"6QIDAQAB";
		//System.out.println(diffieHellman.verify("shashi",sig,pkey));
	}
}
