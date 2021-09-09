//https://programmers.co.kr/learn/courses/30/lessons/60058
//괄호 변환

import java.util.*;

class Solution {
    
    public boolean checkParen(String v){
        String[] characters = v.split("");
        List<String> parenStack = new ArrayList<>();
        boolean check = true;
        
        for(String ch: characters){
            if(check==false){
                break;
            }
            
            if(ch.equals("(")){
                parenStack.add("(");
            } else if(ch.equals(")")){
                int top = parenStack.size()-1;
                if(top>=0){
                    if(parenStack.get(top).equals("(")){
                        parenStack.remove(top);
                        continue;
                    } else {
                        check = false;
                    }
                } else{
                    check=false;
                }
            }
        }
        
        if(parenStack.size()>0){
            check = false;
        }
        
        return check;
    }
    
    public String[] separate(String p){
        String[] answer = new String[2];
        int left = 0;
        int right = 0;
        String u = "";
        String v = "";
        
        String[] characters = p.split("");
        int check = 0;
        for(String ch: characters){
            if(check==1){
                v +=ch;
            } else{
                if(ch.equals("(")){
                    left++;
                    u += ch;
                } else{
                    right++;
                    u += ch;
                }
            
                if(left == right){
                    check = 1;
                }
            }
        }
        answer[0] = u;
        answer[1] = v;
        
        return answer;
    }
    
    public String makeParen(String p){
        String answer = "";
        
        if(p.length() == 0){
            return answer;
        } else if(checkParen(p)){
            answer = p;
            return answer;
        } else{
            String[] UV = separate(p);
            String u = UV[0];
            String v = UV[1];
            
            if(checkParen(u)){
                answer += u;
                answer += makeParen(v);
            } else{
                answer += "(";
                answer += makeParen(v);
                answer += ")";
                String[] uArray = u.split("");
                for(int i=1; i<u.length()-1; i++){
                    if(uArray[i].equals("(")){
                        answer += ")";
                    } else{
                        answer += "(";
                    }
                }
            }
        }
        
        return answer;
    }
    
    public String solution(String p) {
        String answer = "";
        
        if(p.length()==0){
            return answer;
        } else if(checkParen(p)){
            answer = p;
            return answer;
        } else{
            answer = makeParen(p);
        }
        
        return answer;
    }
}