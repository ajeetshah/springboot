package com.learn.springboot.thread;

public class ThreadExample2 implements Runnable {

    public static int amount = 0;

    @Override
    public void run() {
        amount++;
        System.out.println("ThreadExample2");
    }
}
