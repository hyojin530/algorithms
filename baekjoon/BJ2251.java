//https://www.acmicpc.net/problem/2251

import java.util.*;
import java.io.*;

public class BJ2251 {
    static int[] limit = new int[3];
    static boolean[][][] visit = new boolean[201][201][201];
    static boolean[] possible = new boolean[201];

    static class State {
        int[] X;

        public State(int[] _X) {
            X = new int[3];
            for (int i = 0; i < 3; i++) {
                X[i] = _X[i];
            }
        }

        public State move(int from, int to) {
            int[] nX = { X[0], X[1], X[2] };
            if (nX[from] + nX[to] > limit[to]) {
                nX[from] = nX[from] - (limit[to] - nX[to]);
                nX[to] = limit[to];
            } else {
                nX[to] += nX[from];
                nX[from] = 0;
            }

            return new State(nX);
        }
    }

    public static void bfs(int a, int b, int c) {
        Queue<State> stateQue = new LinkedList<>();
        visit[a][b][c] = true;
        int[] start = { a, b, c };
        stateQue.add(new State(start));

        while (!stateQue.isEmpty()) {
            State present = stateQue.poll();
            if (present.X[0] == 0)
                possible[present.X[2]] = true;
            for (int i = 0; i < 3; i++) {
                if (present.X[i] == 0)
                    continue;
                for (int j = 0; j < 3; j++) {
                    if (i == j || present.X[j] == limit[j])
                        continue;
                    State next = present.move(i, j);
                    if (visit[next.X[0]][next.X[1]][next.X[2]] == false) {
                        visit[next.X[0]][next.X[1]][next.X[2]] = true;
                        stateQue.add(next);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        limit[0] = Integer.parseInt(info[0]);
        limit[1] = Integer.parseInt(info[1]);
        limit[2] = Integer.parseInt(info[2]);

        bfs(0, 0, limit[2]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 201; i++) {
            if (possible[i] == true) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
