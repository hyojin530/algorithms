//https://programmers.co.kr/learn/courses/30/lessons/42890
//후보키

import java.util.*;

class Solution {
    
    List<List<Integer>> combiKeys = new ArrayList<>();
    
    public int keyCombi(String[][] relation, List<Integer> keyList, int combiNum){
        List<List<Integer>> combiList = new ArrayList<>();
        
        for(int i=0; i<(1<<keyList.size()); i++){
            List<Integer> combi = new ArrayList<>();
            for(int j=0; j<keyList.size(); j++){
                if((i&(1<<j))==(1<<j)) {
                    combi.add(keyList.get(j));
                }
            }
            if(combi.size() == combiNum){
                if(combiKeys.size()>0){
                    int check = 0;
                    for(List<Integer> combiKey: combiKeys){
                        if(check == 1){
                            break;
                        }
                        for(Integer num: combiKey){
                            if(combi.indexOf(num)==-1){
                                check = 0;
                                break;
                            } else {
                                check = 1;
                            }
                        }
                    }
                    if(check == 0){
                        combiList.add(combi);
                    }
                } else {
                    combiList.add(combi);
                }
            }
        }
        
        System.out.println(combiList);
        
        int keyNum = 0;
        for(List<Integer> combi: combiList){
            HashMap<String, Integer> checkMap = new HashMap<>();
            int unique = 1;

            for(String[] data: relation){
                StringBuilder keyBuilder = new StringBuilder();
                for(Integer num: combi){
                    keyBuilder.append(data[num.intValue()]);
                }
                String key = keyBuilder.toString();
                
                if(checkMap.containsKey(key)){
                    unique = 0;
                    break;
                } else {
                    checkMap.put(key, 1);
                }
            }

            if(unique==1){
                keyNum++;
                combiKeys.add(combi);
            }
        }
        
        return keyNum;
        
    }
    
    public int solution(String[][] relation) {
        int answer = 0;
        int column = relation[0].length;
        List<Integer> keyList = new ArrayList<>();
        
        for(int i=0; i<column; i++){
            HashMap<String, Integer> checkMap = new HashMap<>();
            int unique = 1;
            for(String[] data : relation){
                if(checkMap.containsKey(data[i])){
                    unique = 0;
                    break;
                } else {
                    checkMap.put(data[i], 1);
                }
            }
            if(unique==1){
                answer++;
            } else {
                keyList.add(i);
            }
        }
        
        int combiNum = 2;
        while(keyList.size() >= combiNum){
            answer += keyCombi(relation, keyList, combiNum);
            combiNum++;
            System.out.println(combiKeys);
        }

        System.out.println(keyList);
        
        return answer;
    }
}