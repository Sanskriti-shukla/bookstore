package com.example.test.common.config.advice;

import com.example.test.decorator.Response;
import com.example.test.common.config.exception.NullAwareBeanUtilsBean;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralBeans {
    @Bean
    public ModelMapper modelMapper (){
        return new ModelMapper();
    }
    @Bean
    public NullAwareBeanUtilsBean nullAwareBeanUtilsBean (){
        return new NullAwareBeanUtilsBean();
    } @Bean
    public Response response (){
        return new Response();
    }
}
