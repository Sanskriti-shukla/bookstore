package com.example.test.controller;

import com.example.test.common.config.constant.ResponseConstant;
import com.example.test.decorator.*;
import com.example.test.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    @RequestMapping(name = "addOrUpdateBook", value = "/books/addOrUpdate", method = RequestMethod.POST)
    public DataResponse<BookResponse> addOrUpdateBook(@RequestParam(required = false) String id, @RequestBody BookAddRequest bookAddRequest) {
        DataResponse<BookResponse> dataResponse = new DataResponse<>();
        dataResponse.setData(bookService.addOrUpdateBook(id, bookAddRequest));
        dataResponse.setStatus(Response.getOkResponse(ResponseConstant.SAVED));
        return dataResponse;
    }

    @RequestMapping(name = "getBookById", value = "/books/get/{id}", method = RequestMethod.GET)
    public DataResponse<BookResponse> getBookById(@PathVariable String id) {
        DataResponse<BookResponse> dataResponse = new DataResponse<>();
        dataResponse.setData(bookService.getBookById(id));
        dataResponse.setStatus(Response.getOkResponse(ResponseConstant.OK));
        return dataResponse;
    }

    @RequestMapping(name = "getAllBook", value = "/books/getAllBook", method = RequestMethod.GET)
    public ListResponse<BookResponse> getAllBook() {
        ListResponse<BookResponse> listResponse = new ListResponse<>();
        listResponse.setData(bookService.getAllBook());
        listResponse.setStatus(Response.getOkResponse(ResponseConstant.OK));

        return listResponse;
    }


    @RequestMapping(name = "deleteBook", value = "/books/delete/{id}", method = RequestMethod.DELETE)
    public DataResponse<Object> deleteBook(String id) {
        DataResponse<Object> dataResponse = new DataResponse<>();
        bookService.deleteBook(id);
        dataResponse.setStatus(Response.getOkResponse(ResponseConstant.SUCCESSFULLY_DELETED));
        return dataResponse;
    }

    @RequestMapping(name = "getBookByPrice", value = "Book/Price", method = RequestMethod.POST)
    public ListResponse<BookResponse> getBookByPrice(@RequestBody BookFilter bookFilter) {
        ListResponse<BookResponse> dataResponse = new ListResponse<>();
        dataResponse.setData(bookService.getBookByPrice(bookFilter));
        dataResponse.setStatus(Response.getOkResponse(ResponseConstant.OK));

        return dataResponse;
    }
}

