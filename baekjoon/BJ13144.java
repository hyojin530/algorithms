//https://www.acmicpc.net/problem/13144

import java.io.*;

public class BJ13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arrayInfo = br.readLine().split(" ");
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(arrayInfo[i - 1]);
        }

        int L = 1;
        int R = 1;
        int[] numCheck = new int[100001];
        numCheck[arr[1]] = 1;
        long answer = 0;
        for (int i = 1; i <= N; i++) {
            if (R < N) {
                while (numCheck[arr[R + 1]] != 1) {
                    numCheck[arr[R + 1]] = 1;
                    R++;
                    if (R == N)
                        break;
                }
            }
            answer += (R - L + 1);
            numCheck[arr[L]] = 0;
            L++;
        }

        System.out.println(answer);
    }
}