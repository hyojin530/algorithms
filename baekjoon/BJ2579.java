import java.io.*;

public class BJ2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stNum = Integer.parseInt(br.readLine());
        int[] point = new int[stNum + 1];
        int[][] dp = new int[stNum + 1][2];
        for (int i = 1; i <= stNum; i++) {
            point[i] = Integer.parseInt(br.readLine());
        }

        dp[1][0] = point[1];
        dp[1][1] = point[1];

        if (stNum >= 2) {
            dp[2][0] = point[2];
            dp[2][1] = point[1] + point[2];
        }

        for (int i = 3; i <= stNum; i++) {
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + point[i];
            dp[i][1] = dp[i - 1][0] + point[i];
        }

        System.out.println(Math.max(dp[stNum][0], dp[stNum][1]));

    }

}
