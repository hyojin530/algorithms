//https://www.acmicpc.net/problem/2003

import java.util.*;
import java.io.*;

public class BJ2003 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        System.out.println(twoPointer(arr, m));
    }

    static int twoPointer(int[] arr, int m) {
        int count = 0;
        int startPoint = 0, endPoint = 0;
        int len = arr.length;
        int sum = 0;

        while (true) {
            if (sum >= m) {
                sum -= arr[startPoint++];
            } else {
                if (endPoint >= len)
                    break;
                sum += arr[endPoint++];
            }
            if (sum == m) {
                count++;
            }
        }

        return count;
    }
}
