package com.example.test.service;

import com.example.test.decorator.BookAddRequest;
import com.example.test.decorator.BookResponse;
import com.example.test.model.Book;
import com.example.test.repository.BookRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepo bookRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public BookResponse addBook(BookAddRequest bookAddRequest) {
        Book book = modelMapper.map(bookAddRequest, Book.class);
        BookResponse bookResponse = modelMapper.map(book, BookResponse.class);
        book = bookRepo.save(book);
        return bookResponse;
    }

    @Override
    public BookResponse getBookById(String id) throws Exception {
        Book book = getById(id);
        if (book != null && book.isSoftDelete() == false) {
            BookResponse bookResponse = modelMapper.map(book, BookResponse.class);
            return bookResponse;
        } else {
            throw new Exception();
        }

    }


    @Override
    public List<BookResponse> getAllBook() {
        List<Book> books = bookRepo.findAll();
        List<BookResponse> bookResponses = new ArrayList<>();
        if (books.size() > 0) {
            books.forEach(book -> {
                BookResponse bookResponse = modelMapper.map(book, BookResponse.class);
                if (book.isSoftDelete() == false)
                    bookResponses.add(bookResponse);
            });
        }
        return bookResponses;
    }

    @Override
    public Object bookUpdate(String id, BookAddRequest bookAddRequest) {
        Book book = getById(id);
        if (book != null && book.isSoftDelete() == false) {
            book.setBookName(bookAddRequest.getBookName());
            book.setAuthorName(bookAddRequest.getAuthorName());
            book.setDate(bookAddRequest.getDate());
            bookRepo.save(book);
        }
        return null;
    }

    @Override
    public Object bookDelete(String id) {
        Book book = getById(id);
        if (id != null) {
//            bookRepo.deleteById(id);
            book.setSoftDelete(true);
            bookRepo.save(book);
        } else {
            System.out.println("no id found");
        }

        return null;
    }

    public Book getById(String id) {
        return bookRepo.findById(id).orElseThrow();
    }
}
