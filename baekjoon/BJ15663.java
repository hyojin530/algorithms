//https://www.acmicpc.net/problem/15663

import java.io.*;
import java.util.*;

public class BJ15663 {
    static int N, M;
    static int[] numbers;
    static boolean[] selected;
    static int[] arr; // 1 9와 9 1은 다른 수열 -> selected만으로는 순서 알 수 없음

    public static void rec(int dep) {
        if (dep == M) {
            StringBuilder sb = new StringBuilder();
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }
        int lastest = 0;
        for (int i = 0; i < N; i++) {
            if (selected[i] == false && lastest != numbers[i]) {
                selected[i] = true;
                arr[dep] = numbers[i];
                lastest = numbers[i]; // 같은 자리에 같은 숫자가 오는걸 거르기 위해
                rec(dep + 1);
                selected[i] = false;
                arr[dep] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);

        selected = new boolean[N];
        arr = new int[M];
        rec(0);

    }
}
