package com.example.model;

public class Timer {
    private long startTime;
    private long endTime;

    public void start(){
        startTime = System.currentTimeMillis();
    }
    public long stop(){
        endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
