package com.sn.SNProject.repositories;

import com.sn.SNProject.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<User, String>{
}
