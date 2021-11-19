import java.io.*;

public class BJ16472 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int arrSize = arr.length;

        int L = 0, R = 0;
        int MAX = Integer.MIN_VALUE;
        int[] check = new int[26];
        int kind = 1;
        check[arr[L] - 'a']++;
        for (int i = 0; i < arrSize; i++) {
            while (kind <= N && R + 1 < arrSize) {
                if (check[arr[R + 1] - 'a'] == 0 && kind < N) {
                    kind++;
                    check[arr[R + 1] - 'a']++;
                    R++;
                } else if (check[arr[R + 1] - 'a'] > 0) {
                    check[arr[R + 1] - 'a']++;
                    R++;
                } else {
                    break;
                }
            }
            int size = R - L + 1;
            MAX = Math.max(MAX, size);
            check[arr[L] - 'a']--;
            if (check[arr[L] - 'a'] == 0) {
                kind--;
            }
            L++;
        }

        System.out.println(MAX);
    }
}
