//https://programmers.co.kr/learn/courses/30/lessons/72412#
//순위 검색

import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        List<Integer> answer_list = new ArrayList<>();
        
        for(String query_each: query){
            //언어0 and1 분야2 and3 경력4 and5 음식6 점수7
            String[] condition = query_each.split(" ");
            int result = 0;
            
            for(String participant: info){
                //언어 분야 경력 음식 점수
                String[] prt_cond = participant.split(" ");
                
                if(condition[0].equals(prt_cond[0]) || condition[0].equals("-")){
                    if(condition[2].equals(prt_cond[1]) || condition[2].equals("-")){
                        if(condition[4].equals(prt_cond[2]) || condition[4].equals("-")){
                            if(condition[6].equals(prt_cond[3]) || condition[6].equals("-")){
                                if(Integer.parseInt(prt_cond[4]) >= Integer.parseInt(condition[7])){
                                    result++;
                                }
                            }
                        }
                    }
                }
            }
            
            answer_list.add(result);
            
        }
        
        int[] answer = answer_list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}