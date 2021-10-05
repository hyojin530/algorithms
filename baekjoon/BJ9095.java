//https://www.acmicpc.net/problem/9095

import java.io.*;

public class BJ9095 {
    public static void main(String[] args) throws IOException {

        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 12; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());

        for (int c = 0; c < caseNum; c++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}