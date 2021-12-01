//https://www.acmicpc.net/problem/2252

import java.util.*;
import java.io.*;

public class BJ2252 {
    static int N, M;
    static List<Integer>[] graph;
    static int[] indegree;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        graph = new ArrayList[N + 1];
        indegree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            int v1 = Integer.parseInt(edge[0]);
            int v2 = Integer.parseInt(edge[1]);

            graph[v1].add(v2);
            graph[v2].add(v1);
            indegree[v2]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int v = queue.poll();
            sb.append(v);
            sb.append(" ");
            for (int nv : graph[v]) {
                indegree[nv]--;
                if (indegree[nv] == 0) {
                    queue.add(nv);
                }
            }
        }

        System.out.print(sb.toString());
    }
}
