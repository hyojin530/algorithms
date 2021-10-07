import java.io.*;

public class BJ11066 {

    public static int dynamic(int chNum, String[] chapters) {
        int[][] chapterSum = new int[chNum][chNum];
        for (int i = 0; i < chNum; i++) {
            int sum = 0;
            for (int j = i; j < chNum; j++) {
                sum += Integer.parseInt(chapters[j]);
                chapterSum[i][j] = sum;
            }
        }

        int[][] dp = new int[chNum][chNum];
        for (int i = 0; i < chNum; i++) {
            dp[i][i] = 0;
        }
        for (int i = 0; i < chNum - 1; i++) {
            dp[i][i + 1] = chapterSum[i][i + 1];
        }

        for (int l = 2; l < chNum; l++) {
            for (int i = 0; i < chNum - l; i++) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + chapterSum[i][j]);
                }
            }
        }

        return dp[0][chNum - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dataNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < dataNum; i++) {
            int chNum = Integer.parseInt(br.readLine());
            String[] chapters = br.readLine().split(" ");
            int answer = dynamic(chNum, chapters);
            System.out.println(answer);
        }
    }
}
