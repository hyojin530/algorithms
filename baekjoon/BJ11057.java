//https://www.acmicpc.net/problem/11057

import java.io.*;

public class BJ11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int num = 2; num <= N; num++) {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum = (sum + dp[num - 1][i]) % 10007;
                dp[num][i] = sum;
            }
        }

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = (ans + dp[N][i]) % 10007;
        }

        System.out.println(ans);
    }
}