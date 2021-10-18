//https://www.acmicpc.net/problem/7795

import java.io.*;
import java.util.*;

public class BJ7795 {
    static int[] A, B;

    public static int upperBound(int target) {
        int start = 0;
        int end = A.length;
        int mid = 0;

        while (start < end) {
            mid = (start + end) / 2;
            if (target < A[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            String[] numInfo = br.readLine().split(" ");
            int N = Integer.parseInt(numInfo[0]);
            int M = Integer.parseInt(numInfo[1]);

            A = new int[N];
            B = new int[M];
            String[] AInfo = br.readLine().split(" ");
            for (int a = 0; a < N; a++) {
                A[a] = Integer.parseInt(AInfo[a]);
            }
            String[] BInfo = br.readLine().split(" ");
            for (int b = 0; b < M; b++) {
                B[b] = Integer.parseInt(BInfo[b]);
            }

            int sum = 0;
            Arrays.sort(A);
            Arrays.sort(B);
            for (int k = 0; k < M; k++) {
                int num = B[k];
                sum += (A.length - upperBound(num));
            }
            System.out.println(sum);
        }

    }
}
