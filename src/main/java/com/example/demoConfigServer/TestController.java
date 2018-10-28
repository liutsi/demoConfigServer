package com.example.demoConfigServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class TestController {

    @GetMapping("get1")
    public String get1(){
        return "hello world";
    }

    public static void main(String [] args) {

        Supplier<Stream<String>> sup = ()->Stream.of("a1","a2","a3").filter((s)->{
            System.out.println("filter1:"+s);
            return s.startsWith("a");
        });
        boolean a = sup.get().filter((s)->{
            System.out.println("filter2:"+s);
            return s.startsWith("a");
        }).anyMatch(s->s.length()>1);

        boolean b = sup.get().filter((s)->{
            System.out.println("filter3:"+s);
            return s.startsWith("a");
        }).anyMatch(s->s.length()>2);

    }
}


class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name+":"+age;
    }
}

class Foo {
    String name;
    List<Bar> bars = new ArrayList<>();

    Foo(String name) {
        this.name = name;
    }
}

class Bar {
    String name;

    Bar(String name) {
        this.name = name;
    }
}