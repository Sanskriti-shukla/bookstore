package com.example.test.repository;

import com.example.test.decorator.BookFilter;
import com.example.test.decorator.BookResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class BookCustomRepositoryImpl implements BookCustomRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<BookResponse> getBookByPriceAndSoftDeleteFalse(BookFilter bookFilter) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria = criteria.and("softDelete").is(false);
        if (!StringUtils.isEmpty(bookFilter.getPrice()))
            criteria = criteria.and("price").is(bookFilter.getPrice());
        query.addCriteria(criteria);
        return mongoTemplate.find(query, BookResponse.class, "Book");


    }
}
