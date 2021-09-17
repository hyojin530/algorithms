//https://programmers.co.kr/learn/courses/30/lessons/77484

import java.util.*;

class Solution {
    
    public int ranking(int num){
        int result = 0;
        
        if(num==2) result = 5;
        else if(num==3) result = 4;
        else if(num==4) result = 3;
        else if(num==5) result = 2;
        else if(num==6) result = 1;
        else result = 6;
        
        return result;
    }
    
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int same = 0;
        int zero = 0;
        
        List<Integer> winList = new ArrayList<>();
        
        for(int win: win_nums){
            winList.add(win);
        }
        
        for(int lotto: lottos){
            if(lotto != 0){
                if(winList.indexOf(lotto) != -1){
                    same++;
                    winList.remove(winList.indexOf(lotto));
                }
            } else {
                zero++;
            }
        }
        
        answer[1] = ranking(same);
        answer[0] = ranking(same+zero);

        
        return answer;
    }
}