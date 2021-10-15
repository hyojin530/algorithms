//https://www.acmicpc.net/problem/14502

import java.io.*;
import java.util.*;

public class BJ14502 {
    static int N, M;
    static int[][] area;
    static int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    static int MAX = Integer.MIN_VALUE;

    static class AreaCase {
        int[][] area;

        public AreaCase(int[][] area) {
            this.area = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    this.area[i][j] = area[i][j];
                }
            }
        }

        public void virus() {
            Queue<int[]> que = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (area[i][j] == 2) {
                        int[] start = new int[] { i, j };
                        que.add(start);
                    }
                }
            }

            while (!que.isEmpty()) {
                int[] nP = que.poll();
                for (int d = 0; d < 4; d++) {
                    int nX = nP[0] + dir[d][0];
                    int nY = nP[1] + dir[d][1];
                    if (nX >= 0 && nX < N && nY >= 0 && nY < M) {
                        if (area[nX][nY] == 0) {
                            area[nX][nY] = 2;
                            int[] next = new int[] { nX, nY };
                            que.add(next);
                        }
                    }
                }
            }
        }

        public int checkSafe() {
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (area[i][j] == 0)
                        count++;
                }
            }
            return count;
        }

        public void printArea() {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(area[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static void dfs(int n) {
        if (n == 3) {
            AreaCase newArea = new AreaCase(area);
            newArea.virus();
            MAX = Math.max(MAX, newArea.checkSafe());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] != 0)
                    continue;
                area[i][j] = 1;
                dfs(n + 1);
                area[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numInfo = br.readLine().split(" ");
        N = Integer.parseInt(numInfo[0]);
        M = Integer.parseInt(numInfo[1]);
        area = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] areaInfo = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(areaInfo[j]);
            }
        }
        dfs(0);
        System.out.println(MAX);
    }
}
