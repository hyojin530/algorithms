//정규표현식과 String의 replaceAll을 이용한 간단한 풀이

class Solution {
    public String solution(String new_id) {
        String answer = "";
        String temp = new_id.toLowerCase();

        //허용된 문자가 아니면 없애기"
        temp = temp.replaceAll("[^-_.a-z0-9]","");
        
        //.이 2번 이상 나오는 경우 하나로
        temp = temp.replaceAll("[.]{2,}",".");

        //.이 문자열의 앞이나 끝에 오는 경우에 없애기
        temp = temp.replaceAll("^[.]|[.]$","");
        
        //문자열이 비어있거나 너무 길 경우
        if(temp.equals(""))
            temp+="a";
        if(temp.length() >=16){
            temp = temp.substring(0,15);
            temp=temp.replaceAll("^[.]|[.]$","");
        }

        //문자열이 짧을 경우
        if(temp.length()<=2)
            while(temp.length()<3)
                temp+=temp.charAt(temp.length()-1);

        answer=temp;
        return answer;
    }
}