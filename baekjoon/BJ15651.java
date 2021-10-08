import java.io.*;

public class BJ15651 {
    static int N, M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {
        if (depth == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            selected[depth] = i;
            dfs(depth + 1);
            selected[depth] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        selected = new int[M + 1];
        dfs(1);
        System.out.println(sb.toString());
    }
}
