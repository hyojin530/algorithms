import java.io.*;
import java.util.*;

public class BJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (char ch : charArr) {
            leftStack.add(ch);
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("L")) {
                if (!leftStack.empty()) {
                    rightStack.add(leftStack.pop());
                }
            } else if (cmd[0].equals("D")) {
                if (!rightStack.empty()) {
                    leftStack.add(rightStack.pop());
                }
            } else if (cmd[0].equals("B")) {
                if (!leftStack.empty()) {
                    leftStack.pop();
                }
            } else {
                leftStack.add(cmd[1].charAt(0));
            }

        }

        while (!leftStack.empty()) {
            rightStack.add(leftStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!rightStack.empty()) {
            sb.append(rightStack.pop());
        }

        System.out.print(sb.toString());
    }
}
