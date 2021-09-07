//https://programmers.co.kr/learn/courses/30/lessons/67256
//키패드 누르기

import java.util.*;

class Solution {

    public int[] getCoor(int num, int[][] pad){
        int[] coor = new int[2];
        for(int x=0; x<4; x++){
            for(int y=0; y<3; y++){
                if(pad[x][y] == num){
                    coor[0] = x;
                    coor[1] = y;
                }
            }
        }

        return coor;
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] pad = {{1,2,3}, {4,5,6}, {7,8,9}, {-1, 0, -2}};

        int handFirst = 0;
        if(hand.equals("right")){
            handFirst = 1;
        }
        StringBuilder order = new StringBuilder();
        int left = -1;
        int right = -2;
        for(int num: numbers){
            int[] coor = getCoor(num, pad);

            if(coor[1] == 0){
                left = pad[coor[0]][coor[1]];
                order.append("L");
            } else if(coor[1] == 2){
                right = pad[coor[0]][coor[1]];
                order.append("R");
            } else if(coor[1] == 1){
                int[] leftCoor = getCoor(left, pad);
                int[] rightCoor = getCoor(right, pad);
                int leftLength = Math.abs(coor[0]-leftCoor[0])+Math.abs(coor[1]-leftCoor[1]);
                int rightLength = Math.abs(coor[0]-rightCoor[0])+Math.abs(coor[1]-rightCoor[1]);

                if(leftLength<rightLength){
                    left = pad[coor[0]][coor[1]];
                    order.append("L");
                } else if(rightLength<leftLength){
                    right = pad[coor[0]][coor[1]];
                    order.append("R");
                } else if(rightLength == leftLength){
                    if(handFirst==0){
                        left = pad[coor[0]][coor[1]];
                        order.append("L");
                    } else {
                        right = pad[coor[0]][coor[1]];
                        order.append("R");
                    }
                }
            }
        }

        answer = order.toString();
        return answer;
    }
}