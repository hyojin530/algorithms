//https://www.acmicpc.net/problem/2667

import java.io.*;
import java.util.*;

public class BJ2667 {
    static int N;
    static int[][] houses;
    static boolean[][] visit;
    static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    static List<Integer> housesNum = new ArrayList<>();
    static int num;

    public static void dfs(int x, int y) {
        visit[x][y] = true;
        num += 1;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (visit[nx][ny] == false && houses[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static int find() {
        int count = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (visit[x][y] == true) {
                    continue;
                }
                if (houses[x][y] == 1) {
                    num = 0;
                    dfs(x, y);
                    housesNum.add(num);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        houses = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                houses[i][j] = Integer.parseInt(info[j]);
            }
        }

        int count = find();
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        Collections.sort(housesNum);
        for (int num : housesNum) {
            sb.append(num).append("\n");
        }

        System.out.println(sb.toString());
    }
}
