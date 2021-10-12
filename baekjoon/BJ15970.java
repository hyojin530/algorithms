import java.util.*;
import java.io.*;

public class BJ15970 {

    public static class Point implements Comparable<Point> {
        int x, color;

        public Point(int x, int color) {
            this.x = x;
            this.color = color;
        }

        @Override
        public int compareTo(Point other) {
            return x - other.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point[] pointList = new Point[N];
        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            pointList[i] = new Point(Integer.parseInt(info[0]), Integer.parseInt(info[1]));
        }

        Arrays.sort(pointList);
        int[] lenList = new int[N];
        int length = 0;
        for (int i = 0; i < N; i++) {
            int color = pointList[i].color;
            int x = pointList[i].x;
            boolean find = false;
            for (int j = i + 1; j < N; j++) {
                int right = 0;
                if (pointList[j].color == color) {
                    find = true;
                    right = Math.abs(x - pointList[j].x);
                    if (lenList[i] != 0) {
                        length += Math.min(lenList[i], right);
                    } else {
                        length += right;
                    }
                    lenList[j] = right;
                    break;
                }
            }
            if (find == false) {
                length += lenList[i];
            }
        }

        System.out.println(length);
    }
}
