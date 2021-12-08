import java.io.*;

public class BJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder(br.readLine());
        int cursor = str.length();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("L")) {
                if (cursor > 0) {
                    cursor--;
                }
            } else if (cmd[0].equals("D")) {
                if (cursor < str.length()) {
                    cursor++;
                }
            } else if (cmd[0].equals("B")) {
                if (cursor > 0) {
                    str.deleteCharAt(cursor - 1);
                    cursor--;
                }
            } else {
                str.insert(cursor, cmd[1]);
                cursor++;
            }

        }
        System.out.println(str.toString());
    }
}
