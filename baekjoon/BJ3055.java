import java.util.*;
import java.io.*;

public class BJ3055 {
    static int R, C;
    static int[][] map;
    static boolean[][] visit;
    static int[][] distance;
    static int[][] moves = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static void changeMap() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 1) {
                    queue.add(i);
                    queue.add(j);
                }
            }
        }

        while (!queue.isEmpty()) {
            int X = queue.poll();
            int Y = queue.poll();
            for (int[] move : moves) {
                int nX = X + move[0];
                int nY = Y + move[1];
                if (0 <= nX && nX < R && 0 <= nY && nY < C && map[nX][nY] == 0) {
                    map[nX][nY] = 1;
                }
            }
        }
    }

    public static void bfs(int startX, int startY, int desX, int desY) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startX);
        queue.add(startY);
        visit[startX][startY] = true;
        distance[startX][startY] = 0;
        int time = -1;

        while (!queue.isEmpty()) {
            int X = queue.poll();
            int Y = queue.poll();
            if (X == desX && Y == desY) {
                break;
            }

            if (time < distance[X][Y]) {
                changeMap();
                time = distance[X][Y];
            }

            for (int[] move : moves) {
                int nX = X + move[0];
                int nY = Y + move[1];
                if (0 <= nX && nX < R && 0 <= nY && nY < C && !visit[nX][nY]) {
                    if (map[nX][nY] == 0 || map[nX][nY] == 2) {
                        queue.add(nX);
                        queue.add(nY);
                        visit[nX][nY] = true;
                        distance[nX][nY] = distance[X][Y] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizeInfo = br.readLine().split(" ");
        R = Integer.parseInt(sizeInfo[0]);
        C = Integer.parseInt(sizeInfo[1]);
        map = new int[R][C];
        visit = new boolean[R][C];
        distance = new int[R][C];
        int startX = 0, startY = 0;
        int desX = 0, desY = 0;

        for (int i = 0; i < R; i++) {
            String[] rowInfo = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                if (rowInfo[j].equals(".")) {
                    map[i][j] = 0;
                } else if (rowInfo[j].equals("*")) {
                    map[i][j] = 1;
                } else if (rowInfo[j].equals("X")) {
                    map[i][j] = -1;
                } else {
                    map[i][j] = 2;
                    if (rowInfo[j].equals("S")) {
                        startX = i;
                        startY = j;
                    } else {
                        desX = i;
                        desY = j;
                    }
                }
            }
        }

        bfs(startX, startY, desX, desY);
        if (distance[desX][desY] > 0) {
            System.out.println(distance[desX][desY]);
        } else {
            System.out.println("KAKTUS");
        }

    }
}
