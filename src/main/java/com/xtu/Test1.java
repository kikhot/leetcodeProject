package com.xtu;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        StringBuffer sb = new StringBuffer(str);
        int k = in.nextInt();
        for(int i=0;i<k;i++){
            StringBuffer result = new StringBuffer();
            for(int j=0;j<sb.length();j++){
                if(sb.charAt(j)=='a'){
                    result.append("bc");
                }else if(sb.charAt(j)=='b'){
                    result.append("ca");
                }else if(sb.charAt(j)=='c'){
                    result.append("ab");
                }
            }
            sb = result;
        }
        System.out.println(sb.toString());
    }
}
