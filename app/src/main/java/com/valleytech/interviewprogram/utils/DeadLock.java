package com.valleytech.interviewprogram.utils;

public class DeadLock {

    String str1="java";
    String str2="data";

    int index1=0;
    int index2=0;

    Thread thread1=new Thread(){
        @Override
        public void run() {
            super.run();
            while (true) {
                synchronized (str1) {
                    synchronized (str2) {
                        System.out.println("thread1--> "+index1++);
                    }
                }
            }
        }
    };


    Thread thread2=new Thread(){
        @Override
        public void run() {
            super.run();

            while (true) {
                synchronized (str2) {
                    synchronized (str1) {
                        System.out.println("thread2--> "+index2++);
                    }
                }
            }
        }
    };

    public static void main(String str[])
    {

        DeadLock deadLock=new DeadLock();
        deadLock.thread1.start();
        deadLock.thread2.start();

    }


}
