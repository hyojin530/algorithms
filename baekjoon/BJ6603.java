import java.io.*;
import java.util.*;

public class BJ6603 {
    static int k;
    static int[] arr;
    static boolean[] skip;

    static void dfs(int line, int count) {
        if (count == 6) {
            for (int i = 0; i < k; i++) {
                if (skip[i] == true)
                    System.out.print(arr[i] + " ");
            }
            System.out.println("");
        }

        for (int j = line; j < k; j++) {
            skip[j] = true;
            dfs(j + 1, count + 1);
            skip[j] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] info = br.readLine().split(" ");
            k = Integer.parseInt(info[0]);
            if (k == 0)
                break;

            arr = new int[k];
            skip = new boolean[k];

            for (int i = 1; i <= arr.length; i++) { // 배열 입력
                arr[i] = Integer.parseInt(info[i]);
            }
            Arrays.sort(arr);

            dfs(0, 0);
            System.out.println();
        }
    }
}
