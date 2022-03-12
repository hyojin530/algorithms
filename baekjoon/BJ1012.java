import java.io.*;
import java.util.*;

public class BJ1012 {
    static int M, N, K;
    static int[][] board;
    static boolean[][] visit;
    static int[][] pos = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 상하좌우

    public static void dfs(int x, int y) {
        visit[x][y] = true; // 특정 좌표가 주변과 연결되어있는지 확인
        for (int[] p : pos) { // 상하좌우 확인 -> dfs
            int nx = x + p[0];
            int ny = y + p[1];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (board[nx][ny] == 1 && visit[nx][ny] == false) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int time = 0; time < T; time++) {
            String[] info = br.readLine().split(" ");
            M = Integer.parseInt(info[0]);
            N = Integer.parseInt(info[1]);
            K = Integer.parseInt(info[2]);

            board = new int[M][N];
            for (int i = 0; i < K; i++) {
                int[] loc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                board[loc[0]][loc[1]] = 1;
            }

            visit = new boolean[M][N];
            int caseNum = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j] && board[i][j] == 1) {
                        caseNum++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(caseNum);
        }
    }
}
