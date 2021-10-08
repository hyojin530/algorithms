//https://www.acmicpc.net/problem/1949

import java.io.*;
import java.util.*;

public class BJ1949 {
    static ArrayList<Integer>[] edges;
    static int[] people;
    static int[][] dp;

    public static void dfs(int node, int prev) {
        dp[node][1] = people[node];
        for (int next : edges[node]) {
            if (next == prev) {
                continue;
            }
            dfs(next, node);
            dp[node][0] += Math.max(dp[next][0], dp[next][1]);
            dp[node][1] += dp[next][0];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeNum = Integer.parseInt(br.readLine());
        String[] peopleInfo = br.readLine().split(" ");
        people = new int[nodeNum + 1];
        edges = new ArrayList[nodeNum + 1];
        for (int i = 1; i <= nodeNum; i++) {
            people[i] = Integer.parseInt(peopleInfo[i - 1]);
            edges[i] = new ArrayList<>();
        }

        for (int i = 1; i < nodeNum; i++) {
            String[] edgeInfo = br.readLine().split(" ");
            int u = Integer.parseInt(edgeInfo[0]);
            int v = Integer.parseInt(edgeInfo[1]);
            edges[u].add(v);
            edges[v].add(u);
        }

        dp = new int[nodeNum + 1][2];
        dfs(1, -1);
        int answer = Math.max(dp[1][0], dp[1][1]);
        System.out.println(answer);
    }
}
