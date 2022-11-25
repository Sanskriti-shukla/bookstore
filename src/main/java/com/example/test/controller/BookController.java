package com.example.test.controller;

import com.example.test.model.Book;
import com.example.test.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BookController {
    @Autowired
    private BookRepo bookRepo;
    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book) {
        bookRepo.save(book);

        return "Successfully added";
    }
    @GetMapping("/findAllBooks")

    public List<Book> getBooks() {

        return bookRepo.findAll();


    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable String id) {
        Book book=new Book();
        bookRepo.deleteById(id);
//        book.setSoftDelete(true);
        return "successfully deleted";
    }

}
