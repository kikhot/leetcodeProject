package com.xtu;

public class lc1189 {

    public static int maxNumberOfBalloons(String text) {
        int[] letter = new int[26];
        for(int i=0;i<text.length();i++){
            letter[text.charAt(i)-'a']++;
        }
        int flag = 0;
        int nums = 1;
        while(flag == 0){
            if(letter['b'-'a']>=nums && letter['a'-'a']>=nums && letter['l'-'a']>=nums*2 && letter['o'-'a']>=nums*2 && letter['n'-'a']>=nums){
                nums++;
            }else{
                flag = 1;
            }
        }
        return nums-1;
    }

    public static void main(String[] args) {
        int i = maxNumberOfBalloons("ghrylkxrmb");
        System.out.println(i);
    }

}
