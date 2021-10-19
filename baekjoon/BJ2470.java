//https://www.acmicpc.net/problem/2470

import java.util.*;
import java.io.*;

public class BJ2470 {
    static int[] list;

    public static int binary_search(int start, int end, int target) {
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (list[mid] >= target) {
                end = mid;
            } else if (list[mid] < target) {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new int[N];
        String[] info = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(info[i]);
        }

        Arrays.sort(list);
        int MIN = Integer.MAX_VALUE;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < N; i++) {
            int tempIdx = binary_search(i + 1, list.length - 1, -list[i]);
            if (tempIdx - 1 < N && tempIdx - 1 >= i + 1 && Math.abs(list[tempIdx - 1] + list[i]) < MIN) {
                MIN = Math.abs(list[tempIdx - 1] + list[i]);
                num1 = list[i];
                num2 = list[tempIdx - 1];
            }
            if (tempIdx < N && tempIdx >= i + 1 && Math.abs(list[tempIdx] + list[i]) < MIN) {
                MIN = Math.abs(list[tempIdx] + list[i]);
                num1 = list[i];
                num2 = list[tempIdx];
            }
        }
        System.out.println(num1 + " " + num2);

    }
}
