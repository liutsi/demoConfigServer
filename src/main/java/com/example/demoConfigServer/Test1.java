package com.example.demoConfigServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class Test1 {

    @GetMapping("get10")
    public String get1(){
        return "hello world";
    }

    public static void main(String [] args) {

        List<String> l = new ArrayList(Arrays.asList("one", "two"));
        Stream<String> sl = l.stream();
        l.add("three");
        sl.forEach(System.out::println);


    }
}


