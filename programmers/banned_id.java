//https://programmers.co.kr/learn/courses/30/lessons/64064
//불량사용자

import java.util.*;
import java.util.regex.*;

class Solution {
    
    Set<Set<String>> cases = new HashSet<>();
    String[] combiId;
    
    public List<String> matchId(String ban, String[] user_id){
        List<String> matched = new ArrayList<>();
        String[] bans = ban.split("");
        StringBuilder regexId = new StringBuilder("^");
        
        for(String ch: bans){
            if(ch.equals("*")){
                regexId.append("[a-z0-9]");
            } else{
                regexId.append(ch);
            }
        }
        regexId.append("$");
        String pattern = regexId.toString();
        
        for(String id: user_id){
            if(Pattern.matches(pattern, id)){
                matched.add(id);
            }
        }
        
        return matched;
    }
    
    public void combi(List<List<String>> matchedId, int num){
        if(num==matchedId.size()){
            Set<String> check = new HashSet<>();
            for(int i=0; i<num; i++){
                check.add(combiId[i]);
            }
            if(check.size()==num){
                cases.add(check);
            }
        } else {
            for(int i=0; i<matchedId.get(num).size(); i++){
                combiId[num] = matchedId.get(num).get(i);
                combi(matchedId, num+1);
            }
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        List<List<String>> matchedId = new ArrayList<>();
        
        for(String ban: banned_id){
            matchedId.add(matchId(ban, user_id));
        }
    
        combiId = new String[banned_id.length];
        combi(matchedId, 0);
        answer = cases.size();

        return answer;
    }
}