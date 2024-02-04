package com.xtu;

import java.util.HashSet;
import java.util.Set;

public class LC365 {

    private Set<Long> set = new HashSet<>();

    private int z, jug1Capacity, jug2Capacity;

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        z = targetCapacity;
        this.jug1Capacity = jug1Capacity;
        this.jug2Capacity = jug2Capacity;
        return dfs(0, 0);
    }

    public boolean dfs(int x, int y) {
        long temp = save(x, y);
        if (!set.add(temp)) {
            return false;
        }
        if (x == z || y == z || x + y == z) {
            return true;
        }
        if (dfs(jug1Capacity, y) || dfs(x, jug2Capacity) || dfs(x, 0) || dfs(0, y)) {
            return true;
        }
        int gap1 = Math.min(x, jug2Capacity - y);
        int gap2 = Math.min(jug1Capacity - x, y);
        return dfs(x - gap1, y + gap1) || dfs(x + gap2, y - gap2);
    }

    private long save(int a, int b) {
        return a * 1000000L + b;
    }

}
