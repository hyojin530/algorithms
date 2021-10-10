import java.io.*;
import java.util.*;

public class BJ1759 {
    static int L, C;
    static String[] chars;
    static boolean[] used;
    static int A, B = 0;
    static StringBuilder sb = new StringBuilder();

    public static boolean check(String ch) {
        if (ch.equals("a") || ch.equals("e") || ch.equals("i") || ch.equals("o") || ch.equals("u")) {
            return true;
        }
        return false;
    }

    public static void dfs(int depth, int next) {
        if (depth == L) {
            if (A >= 1 && B >= 2) {
                for (int i = 0; i < C; i++) {
                    if (used[i] == true) {
                        sb.append(chars[i]);
                    }
                }
                sb.append("\n");
            }
            return;
        }
        for (int i = next; i < C; i++) {
            if (used[i] == false) {
                used[i] = true;
                if (check(chars[i])) {
                    A++;
                } else {
                    B++;
                }
                dfs(depth + 1, i + 1);
                used[i] = false;
                if (check(chars[i])) {
                    A--;
                } else {
                    B--;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        L = Integer.parseInt(info[0]);
        C = Integer.parseInt(info[1]);

        String[] charInfo = br.readLine().split(" ");
        chars = new String[C];
        for (int i = 0; i < C; i++) {
            chars[i] = charInfo[i];
        }
        Arrays.sort(chars);
        used = new boolean[C];
        dfs(0, 0);
        System.out.println(sb.toString());
    }
}
