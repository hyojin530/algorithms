import java.io.*;
import java.util.*;

public class BJ1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = info[0];
        int S = info[1];
        int M = info[2];

        int[] vol = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[][] dy = new boolean[N + 1][M + 1];
        dy[0][S] = true;

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = 0;
            boolean flag = false;
            for (int prev = 0; prev <= M; prev++) {
                if (!dy[i - 1][prev])
                    continue;
                for (int cur : new int[] { prev + vol[i - 1], prev - vol[i - 1] }) {
                    if (cur < 0 || cur > M)
                        continue;
                    dy[i][cur] = true;
                    ans = Math.max(ans, cur);
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(ans);
    }
}