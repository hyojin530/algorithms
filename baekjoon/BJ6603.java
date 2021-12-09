import java.io.*;

public class BJ6603 {
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int[] S, boolean[] visited, int depth, int k, int next) {
        if (depth == 6) {
            for (int i = 0; i < k; i++) {
                if (visited[i] == true) {
                    sb.append(S[i] + " ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = next; i < k; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(S, visited, depth + 1, k, i);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] info = br.readLine().split(" ");
            if (info[0].equals("0"))
                break;

            int k = Integer.parseInt(info[0]);
            int[] S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(info[i + 1]);
            }
            boolean[] visited = new boolean[k];
            dfs(S, visited, 0, k, 0);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
