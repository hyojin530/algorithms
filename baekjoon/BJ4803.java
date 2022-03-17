import java.util.*;
import java.io.*;

public class BJ4803 {
    static int caseNum = 0;
    static int n, m;
    static List<Integer>[] graph;
    static boolean[] visit;
    static int edgeNum, vertexNum;

    // tree는 모든 정점에 접근 가능하고 vertex = edge+1
    public static void dfs(int x) {
        visit[x] = true;
        vertexNum++;
        edgeNum += graph[x].size();
        for (int nx : graph[x]) {
            if (visit[nx] == false) {
                dfs(nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] info = br.readLine().split(" ");
            n = Integer.parseInt(info[0]);
            m = Integer.parseInt(info[1]);

            if (n == 0 && m == 0) {
                break;
            }

            graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < m; i++) {
                String[] edge = br.readLine().split(" ");
                int v1 = Integer.parseInt(edge[0]);
                int v2 = Integer.parseInt(edge[1]);
                graph[v1].add(v2);
                graph[v2].add(v1);
            }

            visit = new boolean[n + 1];
            int result = 0;
            for (int i = 1; i <= n; i++) {
                if (visit[i] == false) {
                    edgeNum = 0;
                    vertexNum = 0;
                    dfs(i);
                    if ((edgeNum / 2) == (vertexNum - 1)) {
                        result++;
                    }
                }
            }

            caseNum++;
            System.out.print("Case " + caseNum + ": ");
            if (result == 0) {
                System.out.println("No trees.");
            } else if (result == 1) {
                System.out.println("There is one tree.");
            } else {
                System.out.println("A forest of " + result + " trees.");
            }
        }
    }
}
