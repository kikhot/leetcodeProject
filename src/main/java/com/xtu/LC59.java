package com.xtu;

public class LC59 {
    public int[][] generateMatrix(int n){
        int indexX = 0;
        int indexY = 0;
        int cycle = n/2;
        int[][] resultNum = new int[n][n];
        int count = 0;
        for(int c=1;c<=cycle;c++){
            int i,j;
            for(j=indexY;j<n-c;j++){
                resultNum[indexX][j] = ++count;
            }
            for(i=indexX;i<n-c;i++){
                resultNum[i][j] = ++count;
            }
            for(;j>indexY;j--){
                resultNum[i][j] = ++count;
            }
            for(;i>indexX;i--){
                resultNum[i][j] = ++count;
            }
            indexX++;
            indexY++;
        }
        //n为奇数，证明最后还有一层
        if(n%2==1){
            resultNum[indexX][indexY] = ++count;
        }
        return resultNum;
    }
}
