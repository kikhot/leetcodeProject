package com.xtu;

public class LC670 {
    //    public int maximumSwap(int num) {
//        StringBuffer sb = new StringBuffer(String.valueOf(num));
//        for (int i = 0; i < sb.length(); i++) {
//            char max = '0';
//            int flag = 0;
//            for (int j = sb.length() - 1; j > i; j--) {
//                if (sb.charAt(i) < sb.charAt(j)) {
//                    if (max < sb.charAt(j)) {
//                        max = sb.charAt(j);
//                        flag = j;
//                    }
//                }
//            }
//            if (max != '0') {
//                sb.setCharAt(flag, sb.charAt(i));
//                sb.setCharAt(i, max);
//                break;
//            }
//        }
//        return Integer.parseInt(sb.toString());
//    }
    public int maximumSwap(int num) {
        StringBuffer sb = new StringBuffer(String.valueOf(num));
        int length = sb.length();
        int maxIdx = length - 1;
        int flag1 = -1;
        int flag2 = -1;
        for (int i = length - 2; i >= 0; i--) {
            if (sb.charAt(i) > sb.charAt(maxIdx)) {
                maxIdx = i;
            } else if (sb.charAt(i) < sb.charAt(maxIdx)) {
                flag1 = i;
                flag2 = maxIdx;
            }
        }
        if (flag1 >= 0) {
            char temp = sb.charAt(flag1);
            sb.setCharAt(flag1, sb.charAt(flag2));
            sb.setCharAt(flag2, temp);
        }
        return Integer.parseInt(sb.toString());
    }
}
