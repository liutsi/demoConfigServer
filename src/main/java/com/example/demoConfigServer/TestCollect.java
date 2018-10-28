package com.example.demoConfigServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestCollect {

    @GetMapping("get11")
    public String get1(){
        return "hello world";
    }

    public static void main(String [] args) {

        List<Person> pList = Arrays.asList(
                new Person("a1",11),
                new Person("a2",12),
                new Person("a3",13),
                new Person("a4",14),
                new Person("a5",15),
                new Person("a6",16));

        pList.parallelStream().filter(p->{
            System.out.println("p:"+p.name);
            return p.age>11;
        }).forEachOrdered(System.out::println);

        String s = pList.parallelStream().sequential().parallel().sequential().filter(p->{
            System.out.println("f:"+p.name);
            return p.age>11;
        }).map(p->String.valueOf(p.age)).collect(Collectors.joining(
                " and ",
                "prefix,",
                ",suffix"
        ));
        System.out.println(s);
    }
}


