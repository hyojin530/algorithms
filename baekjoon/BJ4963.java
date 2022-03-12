import java.util.*;
import java.io.*;

public class BJ4963 {
    static int w, h;
    static int[][] board;
    static boolean[][] visit;
    static int[][] pos = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { -1, -1 }, { 1, -1 }, { -1, 1 }, { 1, 1 } };

    public static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int[] p : pos) {
            int nx = x + p[0];
            int ny = y + p[1];
            if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if (board[nx][ny] == 1 && !visit[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            w = info[0];
            h = info[1];

            if (w == 0 && h == 0) {
                break;
            }

            // W, H
            board = new int[h][w];
            visit = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int caseNum = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (board[i][j] == 1 && !visit[i][j]) {
                        caseNum++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(caseNum);
        }
    }
}
