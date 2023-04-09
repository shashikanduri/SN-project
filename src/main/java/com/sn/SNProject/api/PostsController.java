package com.sn.SNProject.api;

import com.sn.SNProject.model.Post;
import com.sn.SNProject.model.User;
import com.sn.SNProject.payloads.MessageResponse;
import com.sn.SNProject.payloads.PostRequest;
import com.sn.SNProject.repositories.PostsRepository;
import com.sn.SNProject.repositories.UsersRepository;
import com.sn.SNProject.services.DiffieHellman;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.util.Objects;
import java.util.Optional;

import static ch.qos.logback.core.encoder.ByteArrayUtil.hexStringToByteArray;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/posts")
@RestController
public class PostsController {
    @Autowired
    UsersRepository userRepository;
    @Autowired
    PostsRepository postsRepository;
    @Autowired
    private DiffieHellman diffieHellman;

    @PostMapping(path="/savepost")
    public ResponseEntity<?> savePost(@Valid @RequestBody PostRequest request) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, InvalidKeySpecException,
            BadPaddingException, InvalidParameterSpecException, InvalidKeyException, NoSuchProviderException, SignatureException {

        Optional<User> userOptional = userRepository.findById(request.getUserId());
        if(!userOptional.isPresent()) {
            return ResponseEntity.status(202).body(new MessageResponse("no such user"));
        }

        User user = userOptional.get();
        byte[] secretKey = hexStringToByteArray(user.getSessionId());
        String imageData = diffieHellman.decrypt(secretKey, request.getEncryptedImage(), request.getIv());

        if(!diffieHellman.verify(imageData, request.getImgSignature(), request.getRsaPublicKey())){
            return ResponseEntity.status(201).body(new MessageResponse("security breach, data tampered!"));
        }

        Post post = new Post(request.getImgSignature(), imageData, request.getUserId(), request.getCaption());
        postsRepository.save(post);

        return ResponseEntity.ok().body(null);
    }
}
