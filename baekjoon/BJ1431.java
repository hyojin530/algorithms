import java.io.*;
import java.util.*;

public class BJ1431 {

    public static int sumSerial(String serial) {
        char[] serialChar = serial.toCharArray();
        int sum = 0;
        for (char c : serialChar) {
            if (('0' <= c && '9' >= c)) {
                sum += c - '0';
            }
        }
        return sum;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] serials = new String[N];
        for (int i = 0; i < N; i++) {
            serials[i] = br.readLine();
        }

        Arrays.sort(serials, (s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }

            int sumDiff = sumSerial(s1) - sumSerial(s2);
            if (sumDiff != 0) {
                return sumDiff;
            }

            return s1.compareTo(s2);
        });

        for (int i = 0; i < N; i++) {
            System.out.println(serials[i]);
        }
    }
}
