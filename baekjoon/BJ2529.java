import java.io.*;

public class BJ2529 {
    static int k;
    static char[] op;
    static int[] num = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    static boolean[] visited = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    static String MAX = String.valueOf(Long.MIN_VALUE);
    static String MIN = String.valueOf(Long.MAX_VALUE);

    public static boolean checkOp(int num1, int num2, int depth) {
        if (op[depth - 1] == '<') {
            if (num1 < num2) {
                return true;
            }
        } else {
            if (num1 > num2) {
                return true;
            }
        }
        return false;
    }

    public static void findNums(int depth) {
        if (depth == k + 1) {
            long number = Long.valueOf(sb.toString());
            if (Long.valueOf(MAX) < number) {
                MAX = sb.toString();
            }
            if (Long.valueOf(MIN) > number) {
                MIN = sb.toString();
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i] == false) {
                if (depth > 0) {
                    if (!checkOp(Character.getNumericValue(sb.charAt(sb.length() - 1)), num[i], depth))
                        continue;
                }
                visited[i] = true;
                sb.append(num[i]);
                findNums(depth + 1);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        String info = br.readLine().replace(" ", "");
        op = info.toCharArray();

        findNums(0);
        System.out.println(MAX);
        System.out.println(MIN);
    }
}