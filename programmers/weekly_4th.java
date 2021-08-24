//https://programmers.co.kr/learn/courses/30/lessons/84325?language=java
//직업군 추천하기

class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int lang_len = languages.length;
        int max_point = 0;
        
        String[] orderedTable = {table[1], table[4], table[2], table[3], table[0]};
        
        for(String langPoint : orderedTable){
            String[] orderedLang = langPoint.split(" ");
            int point = 0;
            
            for(int i=0; i<lang_len; i++){
                for(int j=5; j>0; j--){
                    if(orderedLang[(5-j)+1].equals(languages[i])){
                        point = point + (preference[i]*j);
                        
                        break;
                    }    
                }
            }

            if(point>max_point){
                max_point = point;
                answer = orderedLang[0];
            }
        }
        
        return answer;
    }
}