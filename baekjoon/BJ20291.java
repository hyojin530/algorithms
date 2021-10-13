//https://www.acmicpc.net/status?user_id=dkakfl56&problem_id=20291&from_mine=1

import java.io.*;
import java.util.*;

public class BJ20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> fileMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] fileInfo = br.readLine().split("[.]");
            fileMap.put(fileInfo[1], fileMap.getOrDefault(fileInfo[1], 0) + 1);
        }

        List<String> keyList = new ArrayList(fileMap.keySet());
        Collections.sort(keyList);

        StringBuilder sb = new StringBuilder();
        for (String key : keyList) {
            sb.append(key).append(" ").append(fileMap.get(key)).append("\n");
        }
        System.out.println(sb.toString());
    }

}
