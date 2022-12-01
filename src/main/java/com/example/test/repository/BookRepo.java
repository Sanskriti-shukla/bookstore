package com.example.test.repository;

import com.example.test.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepo extends MongoRepository<Book,String> {
    void deleteById(String id);


}
