import java.io.*;
import java.util.*;

public class BJ2606 {
    static int node[][];
    static int check[];

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        check[start] = 1;
        queue.offer(start);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int i = 1; i < node.length; i++) {
                if (node[x][i] == 1 && check[i] != 1) {
                    queue.offer(i);
                    check[i] = 1;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        node = new int[n + 1][n + 1];
        check = new int[n + 1];
        for (int i = 0; i < m; i++) {
            String[] info = br.readLine().split(" ");
            int a = Integer.parseInt(info[0]);
            int b = Integer.parseInt(info[1]);
            node[a][b] = 1;
            node[b][a] = 1;
        }

        bfs(1);

    }

}