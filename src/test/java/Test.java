import com.xtu.LC2316;

import java.util.Arrays;

public class Test {

    @org.junit.Test
    public void test() {
        int[][] nums = new int[][]{{0, 1}, {0, 2}, {1, 2}};
        countPairs(3, nums);
    }

    public long countPairs(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            unionFind.union(edges[i][0], edges[i][1]);
        }

        long result = 0;
        int[] sizes = unionFind.getSizes();
        for (int i = 0; i < n; i++) {
            result += n - sizes[unionFind.find(i)];
        }

        return result >> 1;

    }

    //并查询
    class UnionFind {
        public int fa[];
        public int sizes[];

        public UnionFind(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            sizes = new int[n];
            Arrays.fill(sizes, 1);
        }

        // 找i的最顶部元素
        public int find(int i) {
            if (fa[i] == i) {
                return i;
            } else {
                fa[i] = find(fa[i]);
                return fa[i];
            }
        }

        // 合并元素
        public void union(int i, int j) {
            int i_fa = find(i);
            int j_fa = find(j);
            if (i_fa != j_fa) {
                fa[i_fa] = j_fa;
                sizes[j_fa] += sizes[i_fa];
            }
        }

        // 获取sizes
        public int[] getSizes() {
            return sizes;
        }
    }
}
