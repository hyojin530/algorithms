//https://www.acmicpc.net/problem/2343

import java.io.*;

public class BJ2343 {
    static int N, M;
    static int[] lecture;

    public static boolean makeBlueray(int len) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum + lecture[i] <= len) {
                sum += lecture[i];
                continue;
            } else {
                count++;
                sum = lecture[i];
            }

            if (count + 1 > M) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        lecture = new int[N];
        String[] lectureInfo = br.readLine().split(" ");
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            lecture[i] = Integer.parseInt(lectureInfo[i]);
            max = Math.max(max, lecture[i]);
        }

        int left = max;
        int right = 1000000000;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (!makeBlueray(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}
