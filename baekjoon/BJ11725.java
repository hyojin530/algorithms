//https://www.acmicpc.net/problem/11725

import java.io.*;
import java.util.*;

public class BJ11725 {
    static ArrayList<Integer>[] edgeList;
    static int[] parentList;

    public static void dfs(int node, int parent) {
        parentList[node] = parent;
        ArrayList<Integer> edges = edgeList[node];
        for (int edge : edges) {
            if (edge == parent)
                continue;
            dfs(edge, node);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        edgeList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edgeList[i] = new ArrayList<Integer>();
        }
        parentList = new int[N + 1];
        for (int i = 0; i < N - 1; i++) {
            String[] edge = br.readLine().split(" ");
            int v1 = Integer.parseInt(edge[0]);
            int v2 = Integer.parseInt(edge[1]);
            edgeList[v1].add(v2);
            edgeList[v2].add(v1);
        }
        dfs(1, -1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parentList[i]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
