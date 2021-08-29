//https://programmers.co.kr/learn/courses/30/lessons/72412#
//순위 검색
//정확성+효율성

import java.util.*;

class Solution {
    
    HashMap<String, List<Integer>> infoMap = new HashMap<>();
    
    public void makeMap(String[] info){
        for(String data:info){
            String[] data_each = data.split(" ");
            int point = Integer.parseInt(data_each[4]);
            
            for(int i=0; i<(1<<4); i++){
                StringBuilder key = new StringBuilder();
                for(int j=0; j<4; j++){
                    if((i&(1<<j)) > 0){
                        key.append(data_each[j]);
                    } else {
                        key.append("-");
                    }
                }
                infoMap.computeIfAbsent(key.toString(), s->new ArrayList<>()).add(point);
            }
        }
    }
    
    public void sortMap(){
        for(Map.Entry<String, List<Integer>> entry : infoMap.entrySet()){
            entry.getValue().sort(null);
        }
    }
    
    public int lowerBound(List<Integer> numList, int target){
        int high = numList.size();
        int low = 0;
        int mid = 0;
        
        while(low < high){
            mid = (high+low)/2;
            if(target <= numList.get(mid)){
                high = mid;
            } else {
                low = mid+1;
            }
        }
        
        return low;
    }
    
    public int[] solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        makeMap(info);
        sortMap();

        for(String data:query){
            String[] condition = data.split(" ");
            String key = condition[0]+condition[2]+condition[4]+condition[6];
            int point = Integer.parseInt(condition[7]);
            
            List<Integer> scoreList = infoMap.getOrDefault(key, empty);

            int num = lowerBound(scoreList, point);
            answer.add(scoreList.size()-num);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}