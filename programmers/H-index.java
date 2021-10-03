//https://programmers.co.kr/learn/courses/30/lessons/42747

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int maxCit = citations[citations.length-1];
        int idx = 0;
        
        for(int i=0; i<maxCit; i++){
            while(citations[idx]<i){
                idx++;
            }
            int num = citations.length - idx;
            if(i<=num){
                if(answer<i){
                    answer = i;
                }
            }
        }

        return answer;
    }
}