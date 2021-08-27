//https://programmers.co.kr/learn/courses/30/lessons/42888
//오픈채팅방

import java.util.*;

class Solution {
    public List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();
        HashMap<String, String> uid_nick = new HashMap<>();
        
        for(String record_each: record){
            String[] action_uid_nick = record_each.split(" ");
            String action = action_uid_nick[0];
            String uid = action_uid_nick[1];
            
            if(action.equals("Enter")){
                uid_nick.put(uid, action_uid_nick[2]);
                answer.add(uid+" 님이 들어왔습니다.");
            } else if(action.equals("Leave")){
                answer.add(uid+" 님이 나갔습니다.");
            } else if(action.equals("Change")){
                uid_nick.put(uid, action_uid_nick[2]);
            }
        }
        
        for(int i=0; i<answer.size(); i++){
            String sentence = answer.get(i);
            String[] uid_words = sentence.split(" ", 2);
            String nick = uid_nick.get(uid_words[0]);
            answer.set(i, nick+uid_words[1]);
        }
        
        
        return answer;
    }
}