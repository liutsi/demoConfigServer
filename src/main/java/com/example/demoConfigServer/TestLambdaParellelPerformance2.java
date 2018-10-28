package com.example.demoConfigServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class TestLambdaParellelPerformance2 {

    @GetMapping("get15")
    public String get1(){
        return "hello world";
    }

    public static void main(String [] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long start = new Date().getTime();
        List<String> stringList = list.parallelStream()
                .filter(i -> i%2==0)
                .map(i -> i.toString())
                .collect(Collectors.toList());
        long end = new Date().getTime();
        System.out.println("lambda used:" + (end - start)); //lambda used:2285ms

        start = new Date().getTime();
        stringList = new ArrayList<>();
        for(Integer i : list){
            if(i%2==0){
                stringList.add(i.toString());
            }
        }
        end = new Date().getTime();
        System.out.println("used:" + (end - start)); // used:1581ms

        /**
         *  最后结果也无法说明for, stream, parallelStream谁快
         */
    }
}


