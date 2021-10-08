import java.io.*;
import java.util.*;

public class BJ15681 {
    static ArrayList<Integer>[] edges;
    static int[] dp;

    public static void dfs(int node, int root) {
        dp[node] = 1;
        for (int next : edges[node]) {
            if (next == root) {
                continue;
            }
            dfs(next, node);
            dp[node] += dp[next];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int nodeNum = Integer.parseInt(info[0]);
        int root = Integer.parseInt(info[1]);
        int queryNum = Integer.parseInt(info[2]);

        edges = new ArrayList[nodeNum + 1];
        for (int i = 1; i <= nodeNum; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 1; i < nodeNum; i++) {
            String[] treeInfo = br.readLine().split(" ");
            int u = Integer.parseInt(treeInfo[0]);
            int v = Integer.parseInt(treeInfo[1]);
            edges[u].add(v);
            edges[v].add(u);
        }

        dp = new int[nodeNum + 1];
        dfs(root, -1);

        for (int i = 0; i < queryNum; i++) {
            int query = Integer.parseInt(br.readLine());
            System.out.println(dp[query]);
        }

    }

}
