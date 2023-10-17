package com.xtu;

import java.util.Arrays;

public class lc1725 {

    public int countGoodRectangles(int[][] rectangles) {
        int[] sort = new int[rectangles.length];
        for(int i=0;i<rectangles.length;i++){
            if(rectangles[i][0]>rectangles[i][1])
                sort[i] = rectangles[i][1];
            else
                sort[i] = rectangles[i][0];
        }
        int count = 0;
        Arrays.sort(sort);
        for(int i=rectangles.length-1;i>=0;i--){
            if(sort[i]==sort[rectangles.length-1])
                count++;
        }
        return count;
    }

}
