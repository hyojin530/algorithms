import java.io.*;

public class BJ14888 {
    static int N;
    static int[] nums;
    static int[] ops;
    static int[] selected;
    static boolean[] used;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void dfs(int depth) {
        if (N - 1 == depth) {
            int result = nums[0];
            for (int i = 0; i < N - 1; i++) {
                switch (selected[i]) {
                    case 1:
                        result += nums[i + 1];
                        break;
                    case 2:
                        result -= nums[i + 1];
                        break;
                    case 3:
                        result *= nums[i + 1];
                        break;
                    case 4:
                        result /= nums[i + 1];
                        break;
                }
            }
            MAX = Math.max(MAX, result);
            MIN = Math.min(MIN, result);
        }
        for (int i = 0; i < N - 1; i++) {
            if (used[i] == false) {
                used[i] = true;
                selected[depth] = ops[i];
                dfs(depth + 1);
                used[i] = false;
                selected[depth] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] numInfo = br.readLine().split(" ");
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(numInfo[i]);
        }

        String[] opInfo = br.readLine().split(" ");
        ops = new int[N - 1];
        int idx = 0;
        for (int i = 1; i <= 4; i++) {
            int opNum = Integer.parseInt(opInfo[i - 1]);
            if (opNum == 0)
                continue;
            for (int j = idx; j < idx + opNum; j++) {
                ops[j] = i;
            }
            idx += opNum;
        }

        selected = new int[N - 1];
        used = new boolean[N - 1];
        dfs(0);
        System.out.println(MAX);
        System.out.println(MIN);
    }
}
