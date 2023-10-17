package com.xtu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JDTest3 {

    public static List<String> findOperations(int x, int y) {
        List<String> operations = new ArrayList<>();

        while(x!=y){
            if(countSetBits(x) < countSetBits(y)){
                operations.add("- "+y);
            }else{
                int maxBit = Integer.highestOneBit(x);
                operations.add("+ " + maxBit);
                x += maxBit;
            }
        }
        return operations;
    }

    public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();

        List<String> operations = findOperations(x, y);
        if(operations.isEmpty()){
            System.out.println("-1");
        }else{
            System.out.println(operations.size());
            for(String operation: operations){
                System.out.println(operation);
            }
        }
    }
}
