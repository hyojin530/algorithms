//https://programmers.co.kr/learn/courses/30/lessons/43165#
//타겟 넘버

import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        List<Integer> numList = new ArrayList<>();
        
        for(int num: numbers){
            if(numList.size()==0){
                numList.add(-num);
                numList.add(num);
            } else{
                int size = numList.size();
                for(int i=0; i<size; i++){
                    int temp = numList.get(0).intValue();
                    numList.add(temp-num);
                    numList.add(temp+num);
                    numList.remove(0);
                }
            }
        }

        for(Integer result: numList){
            if(result.intValue() == target){
                answer++;
            }
        }
        
        return answer;
    }
}