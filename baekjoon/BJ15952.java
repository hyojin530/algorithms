import java.io.*;

public class BJ15952 {
    static int N, M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth) {
        if (depth == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (i < selected[depth - 1])
                continue;
            selected[depth] = i;
            dfs(depth + 1);
            selected[depth] = 0;

        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        selected = new int[M + 1];
        dfs(1);
        System.out.println(sb.toString());
    }
}
