//https://www.acmicpc.net/problem/11652

import java.io.*;
import java.util.*;

public class BJ11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] cards = new long[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(cards);

        int max = 1;
        long maxNum = cards[0];
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (cards[i - 1] == cards[i]) {
                count++;
            } else {
                count = 1;
            }

            if (max < count) {
                maxNum = cards[i];
                max = count;
            }
        }

        System.out.println(maxNum);
    }
}
