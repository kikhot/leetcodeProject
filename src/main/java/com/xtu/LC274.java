package com.xtu;

import java.util.Arrays;
import java.util.Collections;

public class LC274 {
    public int hIndex(int[] citations) {
        //首先对citations进行降序排序
        Arrays.sort(citations);
        for (int i = 0; i < citations.length / 2; i++) {
            int temp = citations[i];
            citations[i] = citations[citations.length - i - 1];
            citations[citations.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(citations));
        for (int i = 0; i < citations.length; i++) {
            if (i + 1 > citations[i])
                return i;
        }
        return citations.length;
    }
}
