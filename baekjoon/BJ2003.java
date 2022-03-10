//https://www.acmicpc.net/problem/2003

import java.util.*;
import java.io.*;

public class BJ2003 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);

        int[] numList = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();

        int sum = 0;
        int caseNum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sum += numList[j];
                if (sum == M) {
                    sum = 0;
                    caseNum++;
                    break;
                } else if (sum > M) {
                    sum = 0;
                    break;
                }
            }
            sum = 0;
        }

        System.out.println(caseNum);
    }
}
