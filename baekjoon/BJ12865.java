import java.io.*;

public class BJ12865 {
    static int N, K;
    static int[] weight;
    static int[] value;
    static int[][] dp;
    static int[][] dpw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        K = Integer.parseInt(info[1]);
        weight = new int[N];
        value = new int[N];
        for (int i = 0; i < N; i++) {
            String[] thingInfo = br.readLine().split(" ");
            weight[i] = Integer.parseInt(thingInfo[0]);
            value[i] = Integer.parseInt(thingInfo[1]);
        }

        dp = new int[N][2];
        dpw = new int[N][2];
        dp[0][0] = 0;
        dp[0][1] = value[0];
        dpw[0][0] = 0;
        dpw[0][1] = weight[0];
        for (int i = 1; i < N; i++) {
            if (dpw[i - 1][1] <= K && dpw[i - 1][0] <= K) {
                if (dp[i - 1][1] > dp[i - 1][0]) {
                    dp[i][0] = dp[i - 1][1];
                    dpw[i][0] = dpw[i - 1][1];
                } else {
                    dp[i][0] = dp[i - 1][0];
                    dpw[i][0] = dpw[i - 1][0];
                }
            } else if (dpw[i - 1][1] <= K) {
                dp[i][0] = dp[i - 1][1];
                dpw[i][0] = dpw[i - 1][1];
            } else if (dpw[i - 1][0] <= K) {
                dp[i][0] = dp[i - 1][0];
                dpw[i][0] = dpw[i - 1][0];
            }

            if (dpw[i - 1][1] + weight[i] <= K && dpw[i - 1][0] + weight[i] <= K) {
                if (dp[i - 1][1] + value[i] > dp[i - 1][0] + value[i]) {
                    dp[i][1] = dp[i - 1][1] + value[i];
                    dpw[i][1] = dpw[i - 1][1] + weight[i];
                } else {
                    dp[i][1] = dp[i - 1][0] + value[i];
                    dpw[i][1] = dpw[i - 1][0] + weight[i];
                }
            } else if (dpw[i - 1][1] + weight[i] <= K) {
                dp[i][1] = dp[i - 1][1] + value[i];
                dpw[i][1] = dpw[i - 1][1] + weight[i];
            } else if (dpw[i - 1][0] + weight[i] <= K) {
                dp[i][1] = dp[i - 1][0] + value[i];
                dpw[i][1] = dpw[i - 1][0] + weight[i];
            }
        }

        int maxValue = 0;
        if (dp[N - 1][1] == 0) {
            maxValue = dp[N - 1][0];
        } else {
            maxValue = Math.max(dp[N - 1][0], dp[N - 1][1]);
        }

        System.out.println(maxValue);
    }
}
