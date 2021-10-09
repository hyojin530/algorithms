import java.io.*;

public class BJ1182 {
    static int N, S;
    static int result = 0;
    static int count = 0;
    static int[] nums;
    static boolean[] used;

    public static void dfs(int depth, int next) {
        if (depth != 0 && result == S) {
            count++;
        }
        if (depth == N) {
            return;
        }
        for (int i = next; i < N; i++) {
            if (used[i] == false) {
                used[i] = true;
                result += nums[i];
                dfs(depth + 1, i);
                result -= nums[i];
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        S = Integer.parseInt(info[1]);

        String[] numInfo = br.readLine().split(" ");
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(numInfo[i]);
        }
        used = new boolean[N];
        dfs(0, 0);
        System.out.println(count);
    }
}
