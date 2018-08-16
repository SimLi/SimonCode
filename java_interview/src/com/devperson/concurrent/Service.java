package com.devperson.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

public class Service {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Exchanger exchanger = new Exchanger();
    }
}
