package com.xtu;

public class JoinTest {
    public static void main(String[] args) {
        Thread T1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t1");
        });

        Thread T2 = new Thread(() -> {
            try {
                T1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t2");
        });

        Thread T3 = new Thread(()->{
            try {
                T2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t3");
        });

        T3.start();
//        T2.start();
//        T1.start();
    }
}
