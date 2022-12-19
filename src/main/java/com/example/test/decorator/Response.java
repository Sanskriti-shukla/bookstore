package com.example.test.decorator;

import com.google.api.Http;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.naming.spi.ResolveResult;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    HttpStatus code;
    String description;
    public static Response getOkResponse(String message){
        return  new Response(HttpStatus.OK,message);
    }
    public  static Response getNotFoundResponse(String message){
        return  new Response(HttpStatus.NOT_FOUND, message);
    }
    public static Response getConflict(String message){
        return  new Response(HttpStatus.CONFLICT, message);
    }
    public  static Response getInternalServerError(String message){
        return  new Response(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }


    public static Response getAlreadyExists(String message) {
        return new Response(HttpStatus.BAD_REQUEST,message);
    }

    public static Response getEmptyResponse(String message) {
        return  new Response(HttpStatus.BAD_REQUEST,message);
    };

    public static Response getInvaildResponse(String message) {
        return  new Response(HttpStatus.BAD_REQUEST,message);
    }
}
