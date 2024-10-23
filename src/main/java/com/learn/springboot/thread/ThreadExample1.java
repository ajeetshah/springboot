package com.learn.springboot.thread;

public class ThreadExample1 extends Thread {

    public static int amount = 0;

    @Override
    public void run() {
        amount++;
        System.out.println("ThreadExample1");
    }
}
