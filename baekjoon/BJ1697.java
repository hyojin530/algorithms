//https://www.acmicpc.net/problem/1697

import java.io.*;
import java.util.*;

class BJ1697 {
    static boolean[] visit = new boolean[100001];
    static int[] distance = new int[100001];

    public static void bfs(int start, int des) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int location = queue.poll();
            if (location == des)
                break;

            if (start > des) {
                if (!visit[location - 1]) {
                    queue.add(location - 1);
                    visit[location - 1] = true;
                    distance[location - 1] = distance[location] + 1;
                }
            } else {
                if (location + 1 <= 100000 && !visit[location + 1]) {
                    queue.add(location + 1);
                    visit[location + 1] = true;
                    distance[location + 1] = distance[location] + 1;
                }
                if (location - 1 >= 0 && !visit[location - 1]) {
                    queue.add(location - 1);
                    visit[location - 1] = true;
                    distance[location - 1] = distance[location] + 1;
                }
                if (location * 2 <= 100000 && !visit[location * 2]) {
                    queue.add(location * 2);
                    visit[location * 2] = true;
                    distance[location * 2] = distance[location] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int K = Integer.parseInt(info[1]);

        bfs(N, K);
        System.out.println(distance[K]);

    }
}