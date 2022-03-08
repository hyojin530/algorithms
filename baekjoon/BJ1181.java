import java.io.*;
import java.util.*;

public class BJ1181 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // 하나의 comparator로 표현
        Arrays.sort(words, (w1, w2) -> {
            if (w1.length() != w2.length()) {
                return w1.length() - w2.length();
            }
            return w1.compareTo(w2);
        });

        for (int i = 0; i < N; i++) {
            if (i != 0) {
                if (words[i].equals(words[i - 1])) {
                    continue;
                }
            }
            System.out.println(words[i]);
        }
    }
}
