package com.example.test.decorator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListResponse<T>{
    List<T> data;
   Response status;

}
