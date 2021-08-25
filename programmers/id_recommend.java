//https://programmers.co.kr/learn/courses/30/lessons/72410
//신규아이디추천
//정규표현식

import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";

        //1단계
        String check_id = new_id.toLowerCase();

        //2단계
        String legal_id = "";
        for(int i=0; i<check_id.length(); i++){
            char char_id = check_id.charAt(i);
            if((97<=(int)char_id) && ((int)char_id<=122)){
                legal_id += char_id;
            } else if ((48<=(int)char_id) && ((int)char_id<=57)){
                legal_id += char_id;
            } else if(char_id == '.'){
                legal_id += char_id;
            } else if(char_id == '-'){
                legal_id += char_id;
            } else if(char_id == '_'){
                legal_id += char_id;
            }
        }

        //3단계
        check_id = legal_id;
        legal_id = "";
        int cnt_point = 0;
        for(int i=0; i<check_id.length(); i++){
            char char_id = check_id.charAt(i);
            if(char_id == '.'){
                cnt_point++;
            } else if(cnt_point > 0){
                legal_id += '.';
                legal_id += char_id;
                cnt_point = 0;
            } else{
                legal_id += char_id;
            }
        }


        //4단계
        check_id = legal_id;
        legal_id = "";
        int check_length = check_id.length();
        if(check_length >= 2){
            if(check_id.charAt(0) == '.'){
                legal_id = check_id.substring(1);
            } else {
                legal_id = check_id;
            }
        } else if(check_length == 1){
            if(check_id.charAt(0) == '.'){
                legal_id = "";
            } else{
                legal_id = check_id;
            }
        }

        //5단계
        check_id = legal_id;
        legal_id = "";
        check_length = check_id.length();
        if(check_length == 0){
            legal_id = "a";
        } else{
            legal_id = check_id;
        }

        //6단계
        check_id = legal_id;
        legal_id = "";
        check_length = check_id.length();
        if(check_length >= 16){
            legal_id = check_id.substring(0, 15);
            if(legal_id.charAt(14) == '.'){
                legal_id = legal_id.substring(0, 14);
            }
        } else{
            legal_id = check_id;
        }

        //7단계
        check_id = legal_id;
        legal_id = "";
        check_length = check_id.length();
        if(check_length <= 2){
            char last_char = check_id.charAt(check_length-1);
            legal_id = check_id;
            while(legal_id.length() <= 2){
                legal_id += last_char;
            }
        } else{
            legal_id = check_id;    
        }

        answer = legal_id;
        return answer;
    }
}