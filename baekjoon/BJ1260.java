//https://www.acmicpc.net/problem/1260

import java.util.*;
import java.io.*;

public class BJ1260 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visit;

    public static String bfs(int start) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new LinkedList<>();
        sb.append(start).append(" ");
        que.add(start);
        visit[start] = true;

        while (!que.isEmpty()) {
            int v = que.poll();
            for (int next : graph.get(v)) {
                if (visit[next] == true)
                    continue;
                sb.append(next).append(" ");
                que.add(next);
                visit[next] = true;
            }
        }

        return sb.toString();
    }

    public static void dfs(int vertex, StringBuilder sb) {
        visit[vertex] = true;
        sb.append(vertex).append(" ");
        for (int next : graph.get(vertex)) {
            if (visit[next] == true)
                continue;
            dfs(next, sb);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        int M = Integer.parseInt(info[1]);
        for (int i = 0; i < M; i++) {
            String[] edgeInfo = br.readLine().split(" ");
            int v1 = Integer.parseInt(edgeInfo[0]);
            int v2 = Integer.parseInt(edgeInfo[1]);
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        int start = Integer.parseInt(info[2]);
        visit = new boolean[N + 1];
        String graphBfs = bfs(start);

        visit = new boolean[N + 1];
        StringBuilder sb = new StringBuilder();
        dfs(start, sb);
        String graphDfs = sb.toString();

        System.out.println(graphDfs);
        System.out.println(graphBfs);
    }
}
