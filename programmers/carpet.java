//https://programmers.co.kr/learn/courses/30/lessons/42842

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int ansX = 0;
        int ansY = 0;
        
        for(int x=0; x<=yellow; x++){
            for(int y=0; y<=x; y++){
                if(x*y == yellow){
                    if((x+2)*(y+2) == brown+yellow){
                        ansX = x+2;
                        ansY = y+2;
                        break;
                    }
                }
            }
            if(ansX != 0){
                break;
            }
        }
        
        answer[0] = ansX;
        answer[1] = ansY;
        
        return answer;
    }
}