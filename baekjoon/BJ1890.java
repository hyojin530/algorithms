//https://www.acmicpc.net/problem/1890

import java.io.*;

public class BJ1890 {
    static int N;
    static int[][] board;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        dp = new long[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String[] rowInfo = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(rowInfo[j - 1]);
            }
        }

        dp[1][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int next = board[i][j];
                if (next == 0)
                    continue;
                if (i + next <= N) {
                    dp[i + next][j] += dp[i][j];
                }
                if (j + next <= N) {
                    dp[i][j + next] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N][N]);
    }
}
