package com.example.test.repository;

import com.example.test.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepo extends MongoRepository<Book,String>, BookCustomRepository {
    Optional<Book> getByIdAndSoftDeleteIsFalse(String id);
    List<Book> findAllBySoftDeleteFalse();


}
