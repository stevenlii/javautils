package com.paymoon.demo.cache.countdownlatch;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable{
    private String name;
    private VideoConference videoConference;

    public Participant(String name, VideoConference videoConference) {
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
        videoConference.arrive(name);
    }
}