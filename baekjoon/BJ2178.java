import java.io.*;
import java.util.*;

public class BJ2178 {
    static int N, M;
    static int[][] area;
    static boolean[][] visit;
    static int[][] road;
    static int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static void bfs(int x, int y) {
        Queue<Integer> que = new LinkedList<>();
        visit[x][y] = true;
        road[x][y] = 1;
        que.add(x);
        que.add(y);

        while (!que.isEmpty()) {
            int nx = que.poll();
            int ny = que.poll();
            for (int d = 0; d < 4; d++) {
                int tx = nx + dir[d][0];
                int ty = ny + dir[d][1];
                if (tx > 0 && tx <= N && ty > 0 && ty <= M) {
                    if (area[tx][ty] == 0) {
                        continue;
                    }
                    if (visit[tx][ty] == true) {
                        continue;
                    }
                    visit[tx][ty] = true;
                    road[tx][ty] = road[nx][ny] + 1;
                    que.add(tx);
                    que.add(ty);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numInfo = br.readLine().split(" ");
        N = Integer.parseInt(numInfo[0]);
        M = Integer.parseInt(numInfo[1]);
        area = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String[] areaInfo = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                area[i][j] = Integer.parseInt(areaInfo[j - 1]);
            }
        }
        visit = new boolean[N + 1][M + 1];
        road = new int[N + 1][M + 1];
        bfs(1, 1);
        System.out.println(road[N][M]);
    }
}
