package com.raisetech.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
public class HelloWorldController {

    @GetMapping("/HelloWorld")
    public String HelloWorld() {
        return "hello world";
    }


    @GetMapping("/date")
    public static String main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(now.format(formatter));

        return now.format(formatter);
    }
}
