package com.example.test.service;

import com.example.test.common.config.constant.MessageConstant;
import com.example.test.decorator.BookAddRequest;
import com.example.test.decorator.BookFilter;
import com.example.test.decorator.BookResponse;
import com.example.test.common.config.exception.NotFoundException;
import com.example.test.common.config.exception.NullAwareBeanUtilsBean;
import com.example.test.model.Book;
import com.example.test.repository.BookRepo;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {


    private final BookRepo bookRepo;
    private final ModelMapper modelMapper;
    private final NullAwareBeanUtilsBean nullAwareBeanUtilsBean;

    @Override
    @SneakyThrows
    public BookResponse addOrUpdateBook(String id, BookAddRequest bookAddRequest) {
        if (id != null) {
            Book book = getbyId(id);
            book.setBookName(bookAddRequest.getBookName());
            book.setAuthor(bookAddRequest.getAuthor());
            book.setDate(bookAddRequest.getDate());
            book.setPrice(bookAddRequest.getPrice());
            book.setDiscount(bookAddRequest.getDiscount());
            BookResponse bookResponse = modelMapper.map(bookAddRequest, BookResponse.class);
            bookRepo.save(book);
            return bookResponse;
        } else {
            Book book = modelMapper.map(bookAddRequest, Book.class);
            BookResponse bookResponse = modelMapper.map(bookAddRequest, BookResponse.class);
            bookRepo.save(book);
            return bookResponse;
        }
    }

    @SneakyThrows
    @Override
    public BookResponse getBookById(String id) {
        Book book = getbyId(id);
        BookResponse bookResponse = new BookResponse();
        nullAwareBeanUtilsBean.copyProperties(bookResponse, book);
        return bookResponse;

    }

    @Override
    public List<BookResponse> getAllBook() {
        List<Book> books = bookRepo.findAllBySoftDeleteFalse();
        List<BookResponse> bookResponses = new ArrayList<>();
        books.forEach(book -> {
            bookResponses.add(modelMapper.map(book, BookResponse.class));
        });
        return bookResponses;
    }

    @Override
    public void deleteBook(String id) {
        Book book = getbyId(id);
        book.setSoftDelete(true);
        bookRepo.save(book);
    }

    @Override
    public List<BookResponse> getBookByPrice(BookFilter bookFilter) {
        return bookRepo.getBookByPriceAndSoftDeleteFalse(bookFilter);
    }

    public Book getbyId(String id) {
        return bookRepo.getByIdAndSoftDeleteIsFalse(id).orElseThrow(() -> new NotFoundException(MessageConstant.BOOK_NOT_FOUND));
    }
}
