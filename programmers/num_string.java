//https://programmers.co.kr/learn/courses/30/lessons/81301

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Map<String, Integer> strToNum = new HashMap<>();
        strToNum.put("zero", 0);
        strToNum.put("one", 1);
        strToNum.put("two", 2);
        strToNum.put("three", 3);
        strToNum.put("four", 4);
        strToNum.put("five", 5);
        strToNum.put("six", 6);
        strToNum.put("seven", 7);
        strToNum.put("eight", 8);
        strToNum.put("nine", 9);
        
        String[] words = s.split("");
        String word = "";
        for(String w: words){
            int num = -1;
            if(48<=w.charAt(0) && w.charAt(0)<=57){
                num = Integer.parseInt(w);
            } else{
                word += w;
                num = strToNum.getOrDefault(word, -1);
            }
        
            if(num>-1){
                answer = answer*10 + num;
                word = "";
            }
        }
        
        return answer;
    }
}