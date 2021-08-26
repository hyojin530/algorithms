//https://programmers.co.kr/learn/courses/30/lessons/64061
//인형뽑기 게임
//스택

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> stack = new ArrayList<>();
        int stack_top = 0;

        for(int move : moves){
            for(int[] board_row:board){
                //인형이 있으면
                if(board_row[move-1] != 0){
                    if(stack_top == board_row[move-1]){ //top과 같은 인형이면
                        stack.remove(stack.size()-1);
                        answer += 2;
                        if(stack.size() == 0){
                            stack_top = 0;
                        } else {
                            stack_top = stack.get(stack.size()-1);
                        }
                    } else{ //같은 인형이 아니면
                        stack.add(board_row[move-1]);
                        stack_top = board_row[move-1];
                    }

                    board_row[move-1] = 0;  //인형 뽑음 처리
                    break;
                }
            }
        }
        return answer;
    }
}