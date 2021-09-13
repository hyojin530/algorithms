//https://programmers.co.kr/learn/courses/30/lessons/42889

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer, Integer> stageMap = new HashMap<>();
        HashMap<Integer, Integer> reachMap = new HashMap<>();
        HashMap<Integer, Float> failMap = new HashMap<>();
        
        for(int stage: stages){
            stageMap.put(stage, stageMap.getOrDefault(stage, 0)+1);
        }
        
        int reach = 0;
        for(int i=N; i>0; i--){
            reach += stageMap.getOrDefault(i, 0);
            reachMap.put(i, reach);
        }
        
        for(int i=1; i<=N; i++){
            int clear = stageMap.getOrDefault(N+1, 0).intValue();
            int stageNum = stageMap.getOrDefault(i, 0).intValue();
            int reachNum = reachMap.getOrDefault(i, 0).intValue() + clear;
            float fail = 0;
            if(stageNum==0 || reachNum==0){
                fail = 0;
                failMap.put(i, (float)0);
            } else{
                fail = (float)stageNum/(float)reachNum;
                failMap.put(i, fail);
            }
        }
        
        List<Map.Entry<Integer, Float>> entryList = new LinkedList<>(failMap.entrySet());
        Collections.sort(entryList, (f1, f2) -> f1.getValue().compareTo(f2.getValue()));
        
        return answer;
    }
}