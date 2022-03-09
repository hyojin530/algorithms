import java.io.*;
import java.util.*;

public class BJ1920 {
    static int[] numList;
    static int[] checkList;

    public static boolean binarySearch(int left, int right, int target) {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        numList = new int[N];
        numList = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
        int M = Integer.parseInt(br.readLine());
        checkList = new int[M];
        checkList = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();

        Arrays.sort(numList); // checkList는 순서변경 안됨

        for (int n : checkList) {
            boolean check = binarySearch(0, N - 1, n);
            if (!check) {
                System.out.println("0");
            } else {
                System.out.println("1");
            }
        }
    }
}
