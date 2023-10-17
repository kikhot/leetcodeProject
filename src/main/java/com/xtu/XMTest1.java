package com.xtu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class XMTest1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String[] split = s1.split(",");
        int towerNum = Integer.valueOf(split[0]);
        int radius = Integer.valueOf(split[1]);
        HashSet<int[]> towers = new HashSet<>();
        int xMax = 0;
        int yMax = 0;
        for(int i=0;i<towerNum;i++){
            String s2 = in.next();
            String[] split1 = s2.split(",");
            int[] tower = new int[3];
            tower[0] = Integer.valueOf(split1[0]);
            tower[1] = Integer.valueOf(split1[1]);
            xMax = xMax<tower[0]?tower[0]:xMax;
            yMax = yMax<tower[1]?tower[1]:yMax;
            tower[2] = Integer.valueOf(split1[2]);
            towers.add(tower);
        }
        //暴力每个坐标，从x开始
        long result = 0;
        int xresult = 0;
        int yresult = 0;
        for(int x=0;x<=xMax+radius;x++){
            for(int y=0;y<yMax+radius;y++){
                long temp = countP(towers, radius, x, y);
                if(temp > result){
                    result = temp;
                    xresult = x;
                    yresult = y;
                }
            }
        }
        System.out.println(xresult+","+yresult);
    }

    public static long countP(HashSet<int[]> towers, int radius, int xi, int yi){
        Iterator<int[]> iterator = towers.iterator();
        long sum = 0;
        while (iterator.hasNext()){
            int[] tower = iterator.next();
            double d = Math.sqrt(Math.pow(xi-tower[0],2)+Math.pow(yi-tower[1],2));
            if(d>radius){
                continue;
            }else{
                sum += (int)(tower[2]/(1+d));
            }
        }
        return sum;
    }
}
