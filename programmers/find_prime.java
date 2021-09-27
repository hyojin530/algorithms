//https://programmers.co.kr/learn/courses/30/lessons/42839

import java.util.*;

class Solution {
    
    Set<Integer> numSet = new HashSet<>();
    StringBuilder numBuilder = new StringBuilder();
    
    public void permutation(char[] chars, boolean[] visit, int depth, int r){
        if(numBuilder.length() == r){
            numSet.add(Integer.valueOf(numBuilder.toString()));
            return;
        }
        
        for(int i=0; i<chars.length; i++){
            if(visit[i]==false){
                visit[i] = true;
                numBuilder.append(chars[i]);
                permutation(chars, visit, depth+1, r);
                visit[i] = false;
                numBuilder.deleteCharAt(numBuilder.length()-1);
            }
        }
    }
    
    public boolean checkPrime(int num){
        if(num<=1 || num==4) return false;
        if(num==2 || num==3) return true;
        if(num>4){
            for(int i=2; i*i<=num; i++){
                if(num%i == 0){
                    return false;
                }
            }
        }
        return true;
    }
    
    public int solution(String numbers) {
        int answer = 0;
        
        boolean[] visit = new boolean[numbers.length()];
        for(int n=1; n<=numbers.length(); n++){
            permutation(numbers.toCharArray(), visit, 0, n);
        }
        
        System.out.println(numSet);
        
        for(Integer num: numSet){
            if(checkPrime(num.intValue())){
                answer++;
                System.out.println(num.intValue());
            }
        }
        
        return answer;
    }
}