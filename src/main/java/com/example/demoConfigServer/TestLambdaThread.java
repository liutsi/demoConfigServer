package com.example.demoConfigServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TestLambdaThread {

    @GetMapping("get1")
    public String get1(){
        return "hello world";
    }

    public static void main(String [] args) {

        System.out.println("ggg:"+Thread.currentThread());
        Thread t = new Thread(()->{System.out.println("hhhh"+Thread.currentThread());});
        t.start();
    }
}


