package com.example.test;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TestApplication implements WebMvcConfigurer {

  /*  @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }*/

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
        System.out.println("hello word");
    }
     @Bean
     public ModelMapper modelMapper (){
         return new ModelMapper();
     }

    }



