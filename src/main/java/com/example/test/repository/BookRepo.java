package com.example.test.repository;

import com.example.test.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepo extends MongoRepository<Book,Integer> {
    void deleteById(String id);
}
