package com.xtu;

public class LC765 {

    public int minSwapsCouples(int[] row) {
        UnionFind unionfind = new UnionFind(row.length);
        for (int i = 0; i < row.length / 2; i++) {
            unionfind.union(2 * i, 2 * i + 1);
        }
        for (int i = 0; i < row.length / 2; i++) {
            unionfind.union(row[2 * i], row[2 * i + 1]);
        }
        return row.length / 2 - unionfind.getCount();
    }

    class UnionFind {

        private int[] father;

        private int count;

        public int getCount() {
            return count;
        }

        UnionFind(int n) {
            this.count = n;
            this.father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        /**
         * 找u对应的根
         *
         * @param u 输入一个值
         * @return 输出所对应的根
         */
        public int find(int u) {
            return u == father[u] ? u : (father[u] = find(father[u]));
        }

        /**
         * 将u插入到v中
         *
         * @param u
         * @param v
         */
        public void union(int u, int v) {
            u = find(u);
            v = find(v);
            //如果u和v相等，则v本来就在u这个并查集上，不用进行任何操作
            if (u == v) {
                return;
            }
            father[u] = v;
            count--;
        }
    }

}
