package com.xtu;

public class LC2594 {
    public long repairCars(int[] ranks, int cars) {
        //二分法查找
        //首先找到最小的数
        int minRank = ranks[0];
        for (int r : ranks) {
            minRank = Math.min(minRank, r);
        }
        //left左指针，right右指针，mid中指针
        long left = 0;
        long right = (long) (minRank * Math.pow(cars, 2));
        while (left + 1 < right) {
            long mid = ((left + right) / 2);
            if(checkCanRepair(ranks, cars, mid)){
                right = mid;
            }else{
                left = mid;
            }
        }
        return right;
    }

    public boolean checkCanRepair(int[] ranks, int cars, long t){
        int sumCar = 0;
        for(int r : ranks){
            sumCar += (int) Math.sqrt(t/r);
        }
        if(sumCar > cars)
            return true;
        return false;
    }
}
