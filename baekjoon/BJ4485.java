import java.io.*;
import java.util.*;

public class BJ4485 {
    static class rupInfo {
        int x;
        int y;
        int sum;

        public rupInfo(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = 0;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            caseNum++;
            if (N == 0)
                break;

            int[][] cave = new int[N][N];
            int[][] rup = new int[N][N];
            for (int i = 0; i < N; i++) {
                cave[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < N; j++) {
                    rup[i][j] = Integer.MAX_VALUE;
                }
            }

            int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
            PriorityQueue<rupInfo> que = new PriorityQueue<>((r1, r2) -> {
                return r1.sum - r2.sum;
            });
            que.add(new rupInfo(0, 0, cave[0][0]));
            rup[0][0] = cave[0][0];

            while (!que.isEmpty()) {
                rupInfo now = que.poll();
                for (int[] dir : direction) {
                    int nx = now.x + dir[0];
                    int ny = now.y + dir[1];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (rup[nx][ny] > now.sum + cave[nx][ny]) {
                            rup[nx][ny] = now.sum + cave[nx][ny];
                            que.add(new rupInfo(nx, ny, now.sum + cave[nx][ny]));
                        }
                    }
                }

            }
            System.out.println("Problem " + caseNum + ": " + rup[N - 1][N - 1]);
        }
    }
}
