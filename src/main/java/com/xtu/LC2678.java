package com.xtu;

public class LC2678 {
    public int countSeniors(String[] details) {
        int result = 0;
        for (int i = 0; i < details.length; i++) {
            String edgeStr = details[i].substring(11, 13);
            int edge = Integer.valueOf(edgeStr);
            if(edge > 60){
                result++;
            }
        }
        return result;
    }
}
