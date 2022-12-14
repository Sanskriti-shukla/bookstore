package com.example.test.decorator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    String bookName;
    Date date= new Date();
    String price;
    double discount;
    @JsonIgnore
    boolean softDelete=false;
}
