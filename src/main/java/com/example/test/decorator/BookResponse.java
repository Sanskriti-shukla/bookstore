package com.example.test.decorator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    String bookName;
    String authorName;
    Date date= new Date();
    @JsonIgnore
    boolean softDelete=false;
}
