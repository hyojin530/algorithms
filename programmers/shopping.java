//https://programmers.co.kr/learn/courses/30/lessons/67258
//보석쇼핑

import java.util.*;

class Solution {
    HashSet<String> gemSet = new HashSet<>();
    
    public int findSection(String[] gems, int start, int gemSize){
        int end = -1;
        for(int i=start+gemSize; i<gems.length; i++){

            String[] gemArray = Arrays.copyOfRange(gems, start, i);
            HashSet<String> tempSet = new HashSet<>();
            for(String gem: gemArray){

                tempSet.add(gem);
            }
            if(Arrays.equals(gemSet.toArray(), tempSet.toArray())){

                end = i;
                break;
            }
        }
        
        return end;
    }
    
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        for(String gem: gems){
            gemSet.add(gem);
        }
        
        System.out.println(gemSet);
        int gemSize = gemSet.size();
        int start = 0;
        int end = gems.length;
        int length = gems.length;
        
        for(int i=0; i<(gems.length-gemSize); i++){
            int tempStart = i;
            int tempEnd = findSection(gems, i, gemSize);
            if(tempEnd != -1){
                if(tempEnd-tempStart<length){
                    System.out.println("start"+tempStart);
                    System.out.println("start"+tempEnd);
                    start = tempStart;
                    end = tempEnd;
                    length = tempEnd-tempStart;
                }
            }
        }
        
        answer[0] = start+1;
        answer[1] = end;
        
        return answer;
    }
}