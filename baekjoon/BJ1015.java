import java.io.*;
import java.util.*;

public class BJ1015 {
    static class Number implements Comparable<Number> {
        int num, idx;

        public Number(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Number other) {
            if (num != other.num) {
                return num - other.num;
            }
            return idx - other.idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] info = br.readLine().split(" ");
        Number[] numList = new Number[num];
        for (int i = 0; i < num; i++) {
            numList[i] = new Number(Integer.parseInt(info[i]), i);
        }
        Arrays.sort(numList);

        int[] P = new int[num];
        for (int i = 0; i < num; i++) {
            P[numList[i].idx] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int n : P) {
            sb.append(n + " ");
        }
        System.out.println(sb.toString());
    }
}
