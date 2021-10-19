//https://www.acmicpc.net/problem/2805

import java.io.*;

public class BJ2805 {
    static int N, M;
    static int[] trees;

    public static boolean cutTree(int height) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (trees[i] > height) {
                sum += trees[i] - height;
            }
        }
        if (sum >= M) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        String[] treeInfo = br.readLine().split(" ");
        trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(treeInfo[i]);
        }

        long left = 0;
        long right = 1000000000;
        long mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (cutTree((int) mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left - 1);
    }
}
