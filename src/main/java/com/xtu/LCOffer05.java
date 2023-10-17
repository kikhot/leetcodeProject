package com.xtu;

public class LCOffer05 {
    public String replaceSpace(String s){

        if(s.length()==0){
            return s;
        }
        //判断s中的空格数
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                sb.append(" ");
            }
        }
        //如果空格数为0，则直接输出
        if(sb.length()==0){
            return s;
        }

        //将空格数扩容2倍放到s的后面
        int left = s.length()-1;
        s += sb.toString() + sb.toString();

        //从后往前用双指针遍历，第一个指针为原始没有扩容s的最后一个元素，第二个指针为扩容之后s的最后一个元素
        int right = s.length()-1;
        char[] chars = s.toCharArray();
        while(left >= 0){
            if(chars[left]!=' '){
                chars[right] = chars[left];
                right--;
                left--;
            }else{
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right--] = '%';
                left--;
            }
        }

        return String.valueOf(chars);
    }
}
