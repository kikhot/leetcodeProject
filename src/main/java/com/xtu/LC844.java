package com.xtu;

public class LC844 {
    public boolean backspaceCompare(String s, String t){
        StringBuffer s1 = new StringBuffer(s);
        StringBuffer t1 = new StringBuffer(t);
        int slowIndexs = 0;
        int slowIndext = 0;
        for(int fastIndexs = 0;fastIndexs < s1.length();fastIndexs++){
            if(s1.charAt(fastIndexs) == '#'){
                slowIndexs = slowIndexs==0?0:slowIndexs-1;
            }else{
                s1.setCharAt(slowIndexs++, s1.charAt(fastIndexs));
            }
        }
        for(int fastIndexs = 0;fastIndexs < t1.length();fastIndexs++){
            if(t1.charAt(fastIndexs) == '#'){
                slowIndext = slowIndext==0?0:slowIndext-1;
            }else{
                t1.setCharAt(slowIndext++, t1.charAt(fastIndexs));
            }
        }
        if(slowIndexs != slowIndext){
            return false;
        }else{
            for(int i=0;i<slowIndexs;i++){
                if(s1.charAt(i) != t1.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
