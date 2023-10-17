package com.xtu;

import java.util.Comparator;
import java.util.TreeMap;

public class LC1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize){
        int count = truckSize;
        int result = 0;

        TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i=0;i<boxTypes.length;i++){
            treeMap.put(boxTypes[i][1],boxTypes[i][0]);
        }
        for(Integer num : treeMap.keySet()){
            if(treeMap.get(num) >= count){
                count -= treeMap.get(num);
                result += treeMap.get(num) * num;
            }else{
                result += num * count;
                count = 0;

            }
        }
        return result;
    }

}
