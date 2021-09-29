//https://programmers.co.kr/learn/courses/30/lessons/42840

import java.util.*;

class Solution {
    
    public int getGrade(int[] pattern, int[] answers){
        int correct = 0;
        int patternNum = pattern.length;
        int answerLong = answers.length;
        for(int i=0; i<answerLong; i++){
            int patternAns = pattern[(i%patternNum)];
            if(answers[i] == patternAns){
                correct++;
            }
        }
        return correct;
    }
    
    public int[] solution(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        int[] grade = new int[3];
        grade[0] = getGrade(first, answers);
        grade[1] = getGrade(second, answers);
        grade[2] = getGrade(third, answers);
        
        int max = 0;
        List<Integer> person = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(max < grade[i]){
                max = grade[i];
                person.clear();
                person.add(i+1);
            } else if(max == grade[i]){
                person.add(i+1);
            }
        }
        
        int[] answer = new int[person.size()];
        for(int s=0; s<person.size(); s++){
            answer[s] = person.get(s);
        }
        return answer;
    }
}