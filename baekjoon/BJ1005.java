//https://www.acmicpc.net/problem/1005

import java.io.*;
import java.util.*;

public class BJ1005 {

    public static int topology(int N, List<Integer>[] edgeList, int[] time, int[] indegree, int W) {
        Queue<Integer> queue = new LinkedList<>();
        int[] totalTime = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                totalTime[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int pTime = totalTime[node];
            for (Integer next : edgeList[node]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
                totalTime[next] = Math.max(totalTime[next], pTime + time[next]);
            }
        }

        return totalTime[W];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String[] info = br.readLine().split(" ");
            int N = Integer.parseInt(info[0]);
            int K = Integer.parseInt(info[1]);

            String[] timeInfo = br.readLine().split(" ");
            int[] time = new int[N + 1];
            List<Integer>[] edgeList = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(timeInfo[i - 1]);
                edgeList[i] = new ArrayList<Integer>();
            }

            int[] indegree = new int[N + 1];
            for (int k = 0; k < K; k++) {
                String[] edgeInfo = br.readLine().split(" ");
                int v1 = Integer.parseInt(edgeInfo[0]);
                int v2 = Integer.parseInt(edgeInfo[1]);
                edgeList[v1].add(v2);
                indegree[v2]++;
            }

            int W = Integer.parseInt(br.readLine());
            int WTime = topology(N, edgeList, time, indegree, W);
            sb.append(WTime);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
