package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import sun.applet.Main;

@SpringBootApplication
public class DemoApplication  extends SpringBootServletInitializer  {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


}
