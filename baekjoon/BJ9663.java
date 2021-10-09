import java.io.*;

public class BJ9663 {
    static int N;
    static int[][] area;
    static int count;

    public static boolean check(int x, int y) {
        for (int i = 0; i < N; i++) {
            if (area[i][y] == 1)
                return false;
        }
        for (int i = 0; i < N; i++) {
            if (area[x][i] == 1)
                return false;
        }
        for (int i = 0; i < N; i++) {
            if (0 <= y - x + i && y - x + i < N) {
                if (area[i][y - x + i] == 1)
                    return false;
            }
        }
        for (int i = 0; i < N; i++) {
            if (x + i < N && y - i >= 0) {
                if (area[x + i][y - i] == 1)
                    return false;
            }
            if (x - i >= 0 && y + i < N) {
                if (area[x - i][y + i] == 1)
                    return false;
            }
        }
        return true;
    }

    public static void dfs(int depth) {
        if (N == depth) {
            count += 1;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (check(depth, j)) {
                area[depth][j] = 1;
                dfs(depth + 1);
                area[depth][j] = 0;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        dfs(0);
        System.out.println(count);
    }
}
