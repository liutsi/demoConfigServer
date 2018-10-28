package com.example.demoConfigServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

@RestController
public class TestController3 {

    @GetMapping("get1")
    public String get1(){
        return "hello world";
    }

    public static void main(String [] args) {

        List<Person> pList = Arrays.asList(
                new Person("a1",12),
                new Person("a2",13),
                new Person("a3",14));
        pList.parallelStream().forEach(System.out::println);
        System.out.println("-----");
        pList.forEach(System.out::println);
        System.out.println("-------2-----------");
        pList.stream().filter(p->p.age>12).forEach(System.out::println);
    }
}


