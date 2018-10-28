package com.example.demoConfigServer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TestLambdaParellelPerformance {

    @GetMapping("get1")
    public String get1(){
        return "hello world";
    }

    public static void main(String [] args) {

        List<Person> pList = new ArrayList<>(20000000);

        long start = System.currentTimeMillis();


        System.out.println("-----:TT,"+(System.currentTimeMillis()-start));
        start = System.currentTimeMillis();

        for (int i =0 ; i<1000000 ;i++){
            pList.add(new Person("a"+i+5, (int)(2000*Math.random())));
        }

        System.out.println("-----:SSSS,"+(System.currentTimeMillis()-start));
        start = System.currentTimeMillis();


        int max1 = pList.stream().filter(p->p.age>1000).mapToInt(p->p.age).sum();

        System.out.println("-----Q:"+max1+","+(System.currentTimeMillis()-start));
        start = System.currentTimeMillis();

        int sum2 = pList.parallelStream().filter(p->p.age>1000).mapToInt(p->p.age).sum();

        System.out.println("-----Q:"+sum2+","+(System.currentTimeMillis()-start));
        start = System.currentTimeMillis();

        /**
         * 测试结果却表明 parallelStream比stream要慢，如何理解？
         */
    }
}


