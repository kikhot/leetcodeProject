package com.xtu;

public class LC2525 {
    public String categorizeBox(int length, int width, int height, int mass) {
        int flag[] = new int[2]; //flag[0]=1表示是Bulky的，flag[1]=1表示是Heavy的
        //箱子 至少有一个 维度大于等于 104 。或者箱子的 体积 大于等于 109 。为Bulky的
        long volume = (long) length * width * height;
        if (volume >= Math.pow(10, 9) || (length >= Math.pow(10, 4) || width >= Math.pow(10, 4) || height >= Math.pow(10, 4))) {
            flag[0] = 1;
        }
        if (mass >= 100) {
            flag[1] = 1;
        }

        if (flag[0] == 1 && flag[1] == 1) {
            return "Both";
        } else if (flag[0] == 1) {
            return "Bulky";
        } else if (flag[1] == 1) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }
}
