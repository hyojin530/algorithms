import java.io.*;
import java.util.*;

public class BJ2056 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int time[] = new int[N + 1];
        int indeg[] = new int[N + 1];
        List<Integer>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            time[i] = info[0];
            graph[i] = new ArrayList<Integer>();
            for (int j = 0; j < info[1]; j++) {
                indeg[info[2 + j]]++;
                graph[i].add(info[2 + j]);
            }
        }

        int[] result = new int[N + 1];
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                que.add(i);
                result[i] = time[i];
            }
        }

        while (!que.isEmpty()) {
            int now = que.poll();
            for (int next : graph[now]) {
                indeg[next]--;
                result[next] = Math.max(result[next], result[now]);
                if (indeg[next] == 0) {
                    que.add(next);
                    result[next] += time[next];
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(result[i], max);
        }

        System.out.println(max);
    }
}
