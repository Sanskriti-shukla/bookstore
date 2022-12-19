package com.example.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "Book")
public class Book {
    @Id
    String id;
    String bookName;
    Date date = new Date();
    String price;
    double discount;
    Author author;
    @JsonIgnore
    boolean softDelete = false;


}
