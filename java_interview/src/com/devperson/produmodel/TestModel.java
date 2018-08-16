package com.devperson.produmodel;

import java.util.Vector;

public class TestModel {

    public static void main(String[] args) {
        Vector vector = new Vector();
        int size = 7;
        Thread proc_thread = new Thread(new Producer(vector,size));
        Thread consum_thread = new Thread(new Consumer(vector,size));
        proc_thread.start();
        consum_thread.start();
    }
}
