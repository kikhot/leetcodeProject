package com.xtu;

import java.util.ArrayList;
import java.util.List;

/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了97.93%的用户
 * 内存消耗：41.7 MB, 在所有 Java 提交中击败了11.04%的用户
 */
public class Lc1380 {

    public List<Integer> luckyNumbers (int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0){
            return null;
        }
        for(int i=0;i<matrix.length;i++){
            int x=i;
            int y=0;
            int min = matrix[i][0];
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] < min){
                    x=i;
                    y=j;
                    min=matrix[i][j];
                }
            }
            int flag = 0;
            for(int m=0;m<matrix.length;m++){
                if(matrix[m][y] > min){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                list.add(matrix[x][y]);
            }
        }
        return list;
    }
}
