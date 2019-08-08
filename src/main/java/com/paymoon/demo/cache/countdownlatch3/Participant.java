package com.paymoon.demo.cache.countdownlatch3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Participant implements Runnable{
    private String name;
    private CountDownLatch videoConference;

    public Participant(String name, CountDownLatch videoConference) {
        this.name = name;
        this.videoConference = videoConference;
    }

    @Override
    public void run() {
        long duration = (long) (Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("..1");
        videoConference.countDown();
    }
}