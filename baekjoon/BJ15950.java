import java.io.*;

public class BJ15950 {
    static int N, M;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth) {
        if (depth == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int start = selected[depth - 1];
        if (start == 0)
            start = 1;
        for (int i = start; i <= N; i++) {
            if (visited[i] != true) {
                selected[depth] = i;
                visited[i] = true;
                dfs(depth + 1);
                selected[depth] = 0;
                visited[i] = false;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        selected = new int[M + 1];
        visited = new boolean[N + 1];
        dfs(1);
        System.out.println(sb.toString());
    }
}
