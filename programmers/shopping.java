//https://programmers.co.kr/learn/courses/30/lessons/67258
//보석쇼핑

import java.util.*;

class Solution {
    HashSet<String> gemSet = new HashSet<>();

    public void makeSet(String[] gems){
        for(String gem: gems){
            gemSet.add(gem);
        }
    }

    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        makeSet(gems);

        int size = gemSet.size();
        int start = 0;
        int end = 0;
        int length = gems.length+1;

        Map<String, Integer> gemMap = new HashMap<>();

        while(true){
            int keySize = gemMap.keySet().size();
            if(start == gems.length){
                break;
            } else if(keySize==size){
                int present = end-start;
                if(length>present){
                    answer[0] = start;
                    answer[1] = end;
                    length = present;
                }
                String key = gems[start];
                gemMap.put(key, gemMap.get(key)-1);
                if(gemMap.get(key)==0){
                    gemMap.remove(key);
                }
                start++;
            } else if(end == gems.length){
                break;
            } else {
                String gem = gems[end];
                gemMap.put(gem, gemMap.getOrDefault(gem, 0)+1);
                end++;
            }

        }

        answer[0]++;

        return answer;
    }
}