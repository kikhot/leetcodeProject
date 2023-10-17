package com.xtu;

public class Demo {
    public static String convert(String s, int numRows) {
        char[][] nums = new char[numRows][s.length()];
        char[] ans = new char[s.length()];
        int flag = 0,i = 0,k=0;
        if(numRows == 1)
            return s;
        while(i<s.length()){
            for(int j=0;j<numRows;j++){
                if(i>=s.length())
                    break;
                else
                    nums[j][flag] = s.charAt(i);
                i++;
            }
            for(int j=0;j<numRows-2;j++){
                flag++;
                if(i>=s.length())
                    break;
                else
                    nums[numRows-j-2][flag] = s.charAt(i);
                i++;
            }
            flag++;

        }

        for(i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(nums[i][j] != '\0'){
                    ans[k] = nums[i][j];
                    k++;
                }
            }
        }
        return new String(ans);
    }

    public static void main(String[] args){
        String ans = convert("PAYPALISHIRING",3);
        System.out.println(ans);

    }
}
