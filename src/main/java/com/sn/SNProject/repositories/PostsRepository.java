package com.sn.SNProject.repositories;

import com.sn.SNProject.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends MongoRepository<Post, String> {
}
