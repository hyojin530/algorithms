//https://programmers.co.kr/learn/courses/30/lessons/43164

import java.util.*;

class Solution {
    
    List<String> list = new ArrayList<>();
    List<String> answerList = new ArrayList<>();
    int find = 0;
    
    public void findRoute(String start, String[][] tickets, boolean[] used, int usedNum){
        int ticketNum = tickets.length;

        if(usedNum == ticketNum){
            find = 1;
            answerList.addAll(list);
            return;
        } else if(find==1){
            return;
        }
        
        for(int i=0; i<ticketNum; i++){
            String[] ticket = tickets[i];
            if(ticket[0].equals(start) && used[i]==false){
                used[i] = true;
                usedNum++;
                list.add(ticket[1]);
                findRoute(ticket[1], tickets, used, usedNum);
                used[i]= false;
                usedNum--;
                list.remove(list.size()-1);
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        boolean[] used = new boolean[tickets.length];
        int usedNum = 0;
        
        Arrays.sort(tickets, (o1, o2) -> {
            if(o1[0].equals(o2[0])){
                return o1[1].compareTo(o2[1]);
            } else {
                return o1[0].compareTo(o2[0]);
            }
        });
        
        answerList.add("ICN");
        findRoute("ICN", tickets, used, usedNum);
        
        String[] answer = new String[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}