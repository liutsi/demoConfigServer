package com.example.demoConfigServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;
import java.util.stream.Stream;

@RestController
public class TestController2 {

    @GetMapping("get123")
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


