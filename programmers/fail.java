//https://programmers.co.kr/learn/courses/30/lessons/42889 (re)

import java.util.*;

class Solution {
    
    static class Stage implements Comparable<Stage>{
        int stageNum;
        double fail;
        
        public Stage(int stageNum, double fail){
            this.stageNum = stageNum;
            this.fail = fail;
        }
        
        @Override
        public int compareTo(Stage s){
            if(this.fail == s.fail){
                return this.stageNum - s.stageNum;
            } else if(this.fail > s.fail){
                return -1;
            } else {
                return 1;
            }
        }
        
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        List<Stage> stageList = new ArrayList<Stage>();
        Arrays.sort(stages);
        int size = stages.length;
        int index = 0;

        for(int i=1; i<=N; i++){
            int cnt = 0;
            for(int j=index; j<stages.length; j++){
                if(stages[j]>i){
                    break;
                }
                cnt++;
                index++;
            }
            if(cnt==0){
                stageList.add(new Stage(i, 0));
            } else{
                stageList.add(new Stage(i, (double)cnt/size));
                size -= cnt;
            }
        }
        
        Collections.sort(stageList);
        for(int i=0; i<N; i++){
            answer[i] = stageList.get(i).stageNum;
        }

        return answer;
    }
}