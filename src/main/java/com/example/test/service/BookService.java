package com.example.test.service;

import com.example.test.decorator.BookAddRequest;
import com.example.test.decorator.BookFilter;
import com.example.test.decorator.BookResponse;

import java.util.List;

public interface BookService {
    BookResponse addOrUpdateBook(String id, BookAddRequest bookAddRequest);

    BookResponse getBookById(String id);

    List<BookResponse> getAllBook();

    void deleteBook(String id);

    List<BookResponse> getBookByPrice(BookFilter bookFilter);
}
