package com.example.test.repository;

import com.example.test.decorator.BookFilter;
import com.example.test.decorator.BookResponse;
import com.example.test.model.Book;

import java.util.List;

public interface BookCustomRepository {
    List<BookResponse>  getBookByPriceAndSoftDeleteFalse(BookFilter bookFilter);
}
