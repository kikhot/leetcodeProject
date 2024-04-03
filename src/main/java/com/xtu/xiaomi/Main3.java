package com.xtu.xiaomi;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();
        // 对s和t从后往前进行遍历，查询出最后一个相同字符的位置
        int lastIndex = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t.charAt(i)) {
                lastIndex = i;
            } else {
                break;
            }
        }
        //查询到之后，比较s和t分别进行转换所需要的操作数，选择操作数最小的那个
        int sCount = countDemo(t, lastIndex);
        int tCount = countDemo(s, lastIndex);

        if (sCount > tCount) {
            System.out.println(tCount);
            replaceDemo(s, lastIndex, 2);
        } else {
            System.out.println(sCount);
            replaceDemo(t, lastIndex, 1);
        }

    }

    // 操作字符串str1，使得和另一个字符串相等, flag为选择第几个字符串进行操作，s为1，t为2
    public static void replaceDemo(String str2, int lastIndex, int flag) {
        if (lastIndex == 0) {
            return;
        }
        Character ch = ' ';
        for (int i = lastIndex - 1; i >= 0; i--) {
            if (str2.charAt(i) != ch) {
                System.out.println(flag + " " + (i + 1) + " " + str2.charAt(i));
                ch = str2.charAt(i);
            }
        }
    }


    // 计算需要多少操作
    public static int countDemo(String str, int lastIndex) {
        int count = 0;
        if (lastIndex == 0) {
            return count;
        }
        Character ch = ' ';
        for (int i = lastIndex - 1; i >= 0; i--) {
            if (str.charAt(i) == ch) {
                continue;
            } else {
                ch = str.charAt(i);
                count++;
            }
        }
        return count;
    }
}
