package com.example.test.decorator;

import com.example.test.model.Author;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookAddRequest {
    String bookName;
    Date date= new Date();
    Author author;
    String price;
    double discount;
}
