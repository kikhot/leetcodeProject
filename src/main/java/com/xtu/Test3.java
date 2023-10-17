package com.xtu;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String str = in.next();
        path = new StringBuffer(str);
        strlen = n;
        findminValue(0, k, 0);
        System.out.println(minValue);
    }

    public static StringBuffer path;
    public static int minValue = Integer.MAX_VALUE;
    public static int strlen;
    public static void findminValue(int indexK, int k, int indexStr){
        if(indexK == k){
            minValue = minValue>checkPathValue(path)?checkPathValue(path):minValue;
            return ;
        }
        if(strlen-indexStr < k-indexK){
            return;
        }
        for(int i=indexStr;i<strlen-k+indexK;i++){
            if(path.charAt(i)=='0'){
                path.setCharAt(i, '1');
            }else{
                path.setCharAt(i, '0');
            }
            findminValue(indexK+1, k, i);
            if(path.charAt(i)=='0'){
                path.setCharAt(i, '1');
            }else{
                path.setCharAt(i, '0');
            }
        }
    }

    public static int checkPathValue(StringBuffer sb){
        int flag = 0;
        char lastCh = ' ';
        int value = 0;
        for(int i=0;i<sb.length();i++){
            if(flag == 0){
                lastCh = sb.charAt(i);
                flag++;
                value++;
            }else{
                if(lastCh == sb.charAt(i)){
                    flag = 0;
                    value--;
                }else{
                    flag = 1;
                    lastCh = sb.charAt(i);
                    value++;
                }
            }
        }
        return value;
    }
}
