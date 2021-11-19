//https://www.acmicpc.net/problem/1253

import java.io.*;
import java.util.*;

public class BJ1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arrInfo = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(arrInfo[i]);
        }
        Arrays.sort(arr);

        int L, R;
        int answer = 0;
        for (int i = 0; i < N; i++) { // 중복된 수가 있다면 가장 작은 수도 가능
            L = 0;
            R = N - 1;
            while (L < R) {
                if (L == i) {
                    L++;
                    continue; // L<R 조건 확인 필요
                }
                if (R == i) {
                    R--;
                    continue;
                }

                if (arr[L] + arr[R] < arr[i]) {
                    L++;
                } else if (arr[L] + arr[R] > arr[i]) {
                    R--;
                } else {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
