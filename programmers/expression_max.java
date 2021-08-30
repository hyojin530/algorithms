//https://programmers.co.kr/learn/courses/30/lessons/67257
//수식 최대화

import java.util.*;
import java.util.regex.Pattern;

class Solution {
    
    int[][] priorityArray = {{1,2,3}, {1,3,2}, {2,1,3}, {2,3,1}, {3,1,2}, {3,2,1}};
    
    public Long calExp(String operand, Long num1, Long num2){
        long result = 0;
        
        switch (operand){
            case "+":
                result = num1.longValue()+num2.longValue();
                break;
            case "-":
                result = num1.longValue()-num2.longValue();
                break;
            case "*":
                result = num1.longValue()*num2.longValue();
                break;
        }
        
        return Long.valueOf(result);
    }
    
    public long calCase(StringTokenizer expToken, int[] arr){
        List<String> operandStack = new ArrayList<>();
        List<Long> numberStack = new ArrayList<>();
        
        String numberPattern = "^[0-9]*$";
        String operandPattern = "^[\\+|\\-|\\*]$";
        
        HashMap<String, Integer> priority = new HashMap<>();
        priority.put("+", arr[0]);
        priority.put("-", arr[1]);
        priority.put("*", arr[2]);
        
        while(expToken.hasMoreTokens()){
            String token = expToken.nextToken();
            
            if(Pattern.matches(numberPattern, token)){
                numberStack.add(Long.valueOf(token));
            } else if(Pattern.matches(operandPattern, token)){
                if(operandStack.size()>0){
                    while(priority.get(operandStack.get(operandStack.size()-1))>=priority.get(token)){
                        String top = operandStack.get(operandStack.size()-1);
                        int size = numberStack.size();
                        
                        Long num = calExp(top, numberStack.get(size-2), numberStack.get(size-1));
                        operandStack.remove(operandStack.size()-1);
                        numberStack.remove(size-1);
                        numberStack.remove(size-2);
                        numberStack.add(num);
                        
                        if(operandStack.size()==0){
                            break;
                        }
                    }
                    
                }
                operandStack.add(token);
            }
        }
        
        while(operandStack.size() > 0){
            String top = operandStack.get(operandStack.size()-1);
            int size = numberStack.size();
                        
            Long num = calExp(top, numberStack.get(size-2), numberStack.get(size-1));
            operandStack.remove(operandStack.size()-1);
            numberStack.remove(size-1);
            numberStack.remove(size-2);
            numberStack.add(num);
        }
        
        System.out.println(numberStack);
        return numberStack.get(0).longValue();
    }
    
    public long solution(String expression) {
        long max = 0;
        
        for(int[] priority: priorityArray){
            StringTokenizer expToken = new StringTokenizer(expression, "+-*", true);
            long temp = Math.abs(calCase(expToken, priority));
            if(temp > max){
                max = temp;
            }
        }
        
        
        return max;
    }
}