package com.example.test.controller;

import com.example.test.decorator.*;
import com.example.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(name = "post", value = "addBook", method = RequestMethod.POST)
    public DataResponse<BookResponse> addBook1(@RequestBody BookAddRequest bookAddRequest) {
        DataResponse<BookResponse> dataResponse = new DataResponse<>();
        try {
            dataResponse.setData(bookService.addBook(bookAddRequest));
            dataResponse.setStatus(Response.getOkResponse("added successfully"));
        } catch (HttpServerErrorException.InternalServerError e) {
            dataResponse.setStatus(Response.getInternalServerError("internal server error"));
        }
        return dataResponse;
    }

    @RequestMapping(name = "getBookById", value = "/get/{id}", method = RequestMethod.GET)
    public DataResponse<BookResponse> getById1(@PathVariable String id) {
        DataResponse<BookResponse> dataResponse = new DataResponse<>();
        try {
            dataResponse.setData(bookService.getBookById(id));
            dataResponse.setStatus(Response.getOkResponse("succesfull"));
        } catch (Exception e) {
            dataResponse.setStatus(Response.getNoFoundResponse("no id found"));
        }
        return dataResponse;
    }

    @RequestMapping(name = "getAll", value = "getAllBook", method = RequestMethod.GET)
    public ListResponse<BookResponse> getAllBook() {
        ListResponse<BookResponse> listResponse = new ListResponse<>();
        try {
            listResponse.setData(bookService.getAllBook());
            listResponse.setStatus(Response.getOkResponse("successfull"));
        } catch (Exception e) {
            listResponse.setStatus(Response.getConflict("no data found"));
        }
        return listResponse;
    }

    @RequestMapping(name = "update", value = "UpdateById/{id}", method = RequestMethod.PUT)
    public DataResponse<Object> updateBook(@PathVariable String id, @RequestBody BookAddRequest bookAddRequest) {
        DataResponse<Object> dataResponse = new DataResponse<>();
        try {
            dataResponse.setData(bookService.bookUpdate(id, bookAddRequest));
            dataResponse.setStatus(Response.getOkResponse("succesfullly updated with given id" + " " + id));
        } catch (Exception e) {
            dataResponse.setStatus(Response.getNoFoundResponse("no id is found"));
        }

        return dataResponse;
    }

    @RequestMapping(name = "delete", value = "delete/{id}", method = RequestMethod.DELETE)
    public DataResponse<Object> deleteBook(String id) {
        DataResponse<Object> dataResponse = new DataResponse<>();
        try {
            dataResponse.setData(bookService.bookDelete(id));
            dataResponse.setStatus(Response.getOkResponse("successfully deleted with given id" + " " + id));
        } catch (Exception e) {
            dataResponse.setStatus(Response.getNoFoundResponse("no id found"));
        }
        return dataResponse;
    }
}

