package com.example.test.common.config.advice;


import com.amazonaws.services.alexaforbusiness.model.NotFoundException;
import com.example.test.decorator.DataResponse;
import com.example.test.decorator.Response;
import com.example.test.common.config.exception.AlreadyExistException;
import com.example.test.common.config.exception.EmptyException;
import com.example.test.common.config.exception.InvalidRequestException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
@ControllerAdvice
@AllArgsConstructor
public class GeneralExceptionHandler {
 private final Response response;
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<DataResponse<Object>> getError(HttpServletRequest req, NotFoundException ex) {
        return new ResponseEntity<>(new DataResponse<>(null, Response.getNotFoundResponse(ex.getMessage())), HttpStatus.OK);
    }
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<DataResponse<Object>> getError(HttpServletRequest req, AlreadyExistException ex) {
        return new ResponseEntity<>(new DataResponse<>(null, Response.getAlreadyExists(ex.getMessage())), HttpStatus.OK);
    }
    @ExceptionHandler(EmptyException.class)
    public ResponseEntity<DataResponse<Object>> getError(HttpServletRequest req, EmptyException ex) {
        return new ResponseEntity<>(new DataResponse<>(null, Response.getEmptyResponse(ex.getMessage())), HttpStatus.OK);
    }
    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<DataResponse<Object>> getError(HttpServletRequest req, InvalidRequestException ex) {
        return new ResponseEntity<>(new DataResponse<>(null, Response.getInvaildResponse(ex.getMessage())), HttpStatus.OK);
    }
}