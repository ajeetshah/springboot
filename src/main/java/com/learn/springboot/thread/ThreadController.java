package com.learn.springboot.thread;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thread")
public class ThreadController {

    @GetMapping("/1")
    public void thread1() {
        ThreadExample1 threadExample1 = new ThreadExample1();
        threadExample1.start();
        while (threadExample1.isAlive()) {
            System.out.println("Waiting...");
        }
        System.out.println(ThreadExample1.amount);
        ThreadExample1.amount++;
        System.out.println(ThreadExample1.amount);
    }

    @GetMapping("/2")
    public void thread2() {
        ThreadExample2 threadExample2 = new ThreadExample2();
        Thread thread = new Thread(threadExample2);
        thread.start();
        while (thread.isAlive()) {
            System.out.println("Waiting...");
        }
        System.out.println(ThreadExample2.amount);
        ThreadExample2.amount++;
        System.out.println(ThreadExample2.amount);
    }

}
