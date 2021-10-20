//https://www.acmicpc.net/problem/2110

import java.io.*;
import java.util.*;

public class BJ2110 {
    static int N, C;
    static int[] home;

    public static boolean minDistance(int dis) {
        int count = C - 1;
        int last = 0;
        for (int i = 1; i < N; i++) {
            if (home[i] - home[last] >= dis) {
                count--;
                last = i;
            }
            if (count == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        C = Integer.parseInt(info[1]);
        home = new int[N];
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);

        int left = 0;
        int right = 1000000000;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (minDistance(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left - 1);
    }
}
