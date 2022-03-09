import java.io.*;
import java.util.*;

public class BJ3273 {
    static int[] numList;

    public static boolean binary(int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numList[mid] == target) {
                return true;
            } else if (numList[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        numList = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(numList);

        int result = 0;
        for (int i = 0; i < N; i++) {
            int target = x - numList[i];
            if (binary(i + 1, N - 1, target)) {
                result++;
            }
        }
        System.out.println(result);
    }
}
