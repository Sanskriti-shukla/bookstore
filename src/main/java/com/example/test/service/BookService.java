package com.example.test.service;

import com.example.test.decorator.BookAddRequest;
import com.example.test.decorator.BookResponse;

import java.util.List;

public interface BookService {
     BookResponse addBook(BookAddRequest bookAddRequest);
    BookResponse getBookById(String id) throws Exception;
  List<  BookResponse> getAllBook();
  Object bookUpdate(String id, BookAddRequest bookAddRequest);
  Object bookDelete(String id);


}
