//https://programmers.co.kr/learn/courses/30/lessons/77485

import java.util.*;

class Solution {
    List<Integer> minNum = new ArrayList<>();
    
    public int[][] move(int[][] box, int x1, int y1, int x2, int y2){
        int[][] newBox = new int[box.length][box[0].length];
        
        for(int i=0; i<box.length; i++){
            for(int j=0; j<box[0].length; j++){
                newBox[i][j] = box[i][j];
            }
        }
        
        int min = 0;
        for(int i=x1-1; i<x2; i++){
            for(int j=y1-1; j<y2; j++){
                boolean change = false;
                if(i==x1-1){
                    if(j==y1-1){
                        newBox[i][j] = box[i+1][j];
                    } else{
                        newBox[i][j] = box[i][j-1];
                    }
                    change = true;
                } else if(j==y2-1){
                    newBox[i][j] = box[i-1][j];
                    change = true;
                } else if(i==x2-1){
                    newBox[i][j] = box[i][j+1];
                    change = true;
                } else if(j==y1-1){
                    newBox[i][j] = box[i+1][j];
                    change = true;
                }
                
                if(change){
                    if(min==0 || min>newBox[i][j]){
                        min = newBox[i][j];
                    }
                }
            }
        }
        
        minNum.add(min);
        
        return newBox;
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {   
        
        int[][] box = new int[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                box[i][j] = i*columns+j+1;
            }
        }
        
        for(int[] query: queries){
            box = move(box, query[0], query[1], query[2], query[3]);
        }
        
        int[] answer = new int[minNum.size()];
        for(int i=0; i<minNum.size(); i++){
            answer[i] = minNum.get(i);
        }
        
        return answer;
    }
}