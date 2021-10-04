//https://programmers.co.kr/learn/courses/30/lessons/42895

import java.util.*;

class Solution {
    
    static HashSet<Integer>[] dp = new HashSet[9];
    
    public void cal(int i, int j){
        Iterator<Integer> iter1 = dp[j].iterator();
        Iterator<Integer> iter2 = dp[i-j].iterator();
        
        while(iter1.hasNext()){
            int num1 = iter1.next();
            while(iter2.hasNext()){
                int num2 = iter2.next();
                dp[i].add(num1+num2);
                dp[i].add(num1-num2);
                dp[i].add(num1*num2);
                if(num2!=0) dp[i].add(num1/num2);
            }
            iter2 = dp[i-j].iterator();
        }
    }
    
    public int solution(int N, int number) {
        if(N==number){
            return 1;
        }
        
        String Ns = "";
        for(int i=1; i<9; i++){
            Ns += String.valueOf(N);
            dp[i] = new HashSet<Integer>();
            dp[i].add(Integer.parseInt(Ns));
            if(Integer.parseInt(Ns) == number){
                return i;
            }
            
            for(int j=1; j<i; j++){
                cal(i, j);
                if(dp[i].contains(number)){
                    return i;
                }
            }
        }

        return -1;
    }
}