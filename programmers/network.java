//https://programmers.co.kr/learn/courses/30/lessons/43162
//네트워크

import java.util.*;

class Solution {
    
    public void bfs(int[][] computers, List<Integer> queue, List<Integer> computerList){
        while(queue.size()>0){
            int computer = queue.get(0);
            for(int i=0; i<computerList.size(); i++){
                if(computers[computer][computerList.get(i)]==1){
                    queue.add(computerList.get(i));
                    computerList.remove(i);
                    i--;
                }
            }
            queue.remove(0);
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        List<Integer> computerList = new ArrayList<>();
        List<Integer> queue = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            computerList.add(i);
        }

        while(computerList.size()>0){
            queue.add(computerList.get(0));
            computerList.remove(0);
            bfs(computers, queue, computerList);
            answer++;
        }
        
        return answer;
    }
}