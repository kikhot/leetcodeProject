package com.xtu.xiaomi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int k = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        //写作 m, 听力 m-x, 阅读 m+y
        int m = (k + x - y) / 3;

        System.out.print((m - x) + " " + (m + y) + " " + m);

    }
}
