package com.xtu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JDTest2 {

    static class Node {
        int id;
        List<Node> neighbors;

        Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }
    }

    public static boolean canWin(Node root, int x) {
        if (root == null) {
            return false;
        }
        if (root.id == x) {
            return true;
        }
        if (root.neighbors.size() == 1) {
            return false;
        }

        boolean result = false;
        for (Node neighbor : root.neighbors) {
            result |= !canWin(neighbor, x);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int x = in.nextInt();
            Node[] nodes = new Node[n+1];
            for(int j=1;j<=n;j++){
                nodes[j] = new Node(j);
            }

            for(int j=1;j<=n-1;j++){
                int u = in.nextInt();
                int v = in.nextInt();

                nodes[u].neighbors.add(nodes[v]);
                nodes[v].neighbors.add(nodes[u]);
            }

            boolean result = canWin(nodes[x],x);

            if(result){
                System.out.println("win");
            }else{
                System.out.println("lose");
            }

        }
    }
}
