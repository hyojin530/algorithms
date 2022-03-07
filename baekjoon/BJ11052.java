import java.io.*;

public class BJ11052 {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] info = br.readLine().split(" ");
        int[] price = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            price[i] = Integer.parseInt(info[i - 1]);
        }

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = price[1];
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (dp[i] < dp[j] + price[i - j]) {
                    dp[i] = dp[j] + price[i - j];
                }
            }
            dp[i] = Math.max(dp[i], price[i]);
        }

        System.out.print(dp[N]);
    }
}
