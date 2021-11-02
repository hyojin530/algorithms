//https://www.acmicpc.net/problem/1806

import java.io.*;

public class BJ1806 {
    static int N, S;
    static int[] numbers;

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        S = Integer.parseInt(info[1]);
        numbers = new int[N];
        String[] numInfo = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(numInfo[i]);
        }

        int ptr1 = 0;
        int ptr2 = 0;
        int sum = numbers[ptr1];
        int MIN = Integer.MAX_VALUE;
        while (ptr2 < N) {
            if (sum >= S) {
                MIN = Math.min(MIN, ptr2 - ptr1 + 1);
                sum -= numbers[ptr1];
                ptr1++;
            } else {
                while (sum < S) {
                    ptr2++;
                    if (ptr2 >= N)
                        break;
                    sum += numbers[ptr2];
                }
            }
        }

        if (MIN == Integer.MAX_VALUE) {
            MIN = 0;
        }

        System.out.println(MIN);
    }
}
