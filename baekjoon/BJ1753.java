import java.util.*;
import java.io.*;

class BJ1753 {
    static int V, E;
    static int K;
    static List<Edge>[] edgeList;
    static int[] distance;

    static class Edge {
        int to;
        int weight;

        public Edge(int _to, int _weight) {
            to = _to;
            weight = _weight;
        }
    }

    static class Info {
        int vertex;
        int distance;

        public Info() {

        }

        public Info(int _vertex, int _distance) {
            vertex = _vertex;
            distance = _distance;
        }
    }

    static void dijkstra(int start) {
        for (int i = 1; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {
            Info minInfo = pq.poll();
            int x = minInfo.vertex;
            if (distance[x] < minInfo.distance)
                continue;

            distance[x] = minInfo.distance;
            for (Edge edge : edgeList[x]) {
                if (distance[x] + edge.weight < distance[edge.to]) {
                    distance[edge.to] = distance[x] + edge.weight;
                    pq.add(new Info(edge.to, distance[edge.to]));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String info[] = br.readLine().split(" ");
        V = Integer.parseInt(info[0]);
        E = Integer.parseInt(info[1]);
        K = Integer.parseInt(br.readLine());

        edgeList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            String[] edgeInfo = br.readLine().split(" ");
            int from = Integer.parseInt(edgeInfo[0]);
            int to = Integer.parseInt(edgeInfo[1]);
            int weight = Integer.parseInt(edgeInfo[2]);
            Edge newEdge = new Edge(to, weight);
            edgeList[from].add(newEdge);
        }

        distance = new int[V + 1];
        dijkstra(K);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(distance[i] + "\n");
            }
        }
        System.out.println(sb.toString());

    }
}