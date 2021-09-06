//https://programmers.co.kr/learn/courses/30/lessons/64065
//튜플

import java.util.*;

class Solution {
    public int[] solution(String s) {

        String[] chars = s.split("\\,|\\{|\\}");
        Map<Integer, Integer> numMap = new HashMap<>();

        for(String ch: chars){
            if(ch.length()>0){
                Integer num = Integer.valueOf(ch);
                numMap.put(num, numMap.getOrDefault(num, 0)+1);
            }
        }

        int size = numMap.keySet().size();
        int[] answer = new int[size];

        for(Map.Entry<Integer, Integer> entry: numMap.entrySet()){
            int key = entry.getKey().intValue();
            int value = entry.getValue().intValue();
            answer[size-value] = key;
        }

        return answer;
    }
}
