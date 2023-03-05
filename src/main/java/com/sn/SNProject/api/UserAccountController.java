package com.sn.SNProject.api;

import com.sn.SNProject.model.User;
import com.sn.SNProject.payloads.MessageResponse;
import com.sn.SNProject.payloads.SignupRequest;
import com.sn.SNProject.repositories.UsersRepository;
import com.sn.SNProject.services.UserAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/users")
@RestController
public class UserAccountController {

    @Autowired
    UserAccountService userAccountService;

    @Autowired
    UsersRepository userRepository;



    @PostMapping(path="/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest request){


        return ResponseEntity.ok(new MessageResponse("yes"));
    }

    @GetMapping(path="/getPDSKey")
    public ResponseEntity<?> getServerPublicKey() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        byte[] x = userAccountService.getPdsPublicKey();

        return ResponseEntity.ok(new MessageResponse(Base64.getEncoder().encodeToString(x)));

    }


}
