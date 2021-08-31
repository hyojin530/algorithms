//https://programmers.co.kr/learn/courses/30/lessons/72411
//메뉴 리뉴얼

import java.util.*;

class Solution {
    
    public HashMap<String, List<Integer>> orderMap = new HashMap<>();
    
    public int binarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        
        while(low<= high){
            mid = (low+high)/2;
            if(target == nums[mid]){
                return mid;
            } else if(target<nums[mid]){
                high = mid-1;
            } else if(target>nums[mid]){
                low = mid+1;
            }
        }
        
        return -1;
    }
    
    public void orderCom(Integer orderNum, String order, int[] course){
        String[] menu = order.split("");
        Arrays.sort(menu);
        for(int i = 0; i<(1<<menu.length); i++){
            StringBuilder combi = new StringBuilder();
            for(int j = 0; j<menu.length; j++){
                if((i&(1<<j))==(1<<j)) combi.append(menu[j]);
            }
            
            if(binarySearch(course, combi.length()) != -1){
                orderMap.computeIfAbsent(combi.toString(), k->new ArrayList<>()).add(orderNum);
            }
            
        }
        
        
        
    }
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        int orderNum = 0;
        for(String order: orders){
            orderCom(orderNum, order, course);
            orderNum++;
        }
        
        HashMap<Integer, List<String>> menuMap = new HashMap<>();
        
        for(Map.Entry<String, List<Integer>> entry: orderMap.entrySet()){
            if(entry.getValue().size() >= 2){
                int length = entry.getKey().length();
                if(menuMap.containsKey(length)){
                    String temp = menuMap.get(length).get(0);
                    int max = orderMap.get(temp).size();
                    if(entry.getValue().size() == max){
                        menuMap.get(length).add(entry.getKey());
                    } else if (entry.getValue().size() > max){
                        List<String> newList = new ArrayList<>();
                        newList.add(entry.getKey());
                        menuMap.put(length, newList);
                    }
                } else {
                    List<String> newList = new ArrayList<>();
                    newList.add(entry.getKey());
                    menuMap.put(length, newList);
                }
            }
        }
        
        List<String> resultList = new ArrayList<>();
        
        for(Map.Entry<Integer, List<String>> entry: menuMap.entrySet()){
            resultList.addAll(entry.getValue());
        }
        resultList.sort(null);
        answer = resultList.toArray(new String[resultList.size()]);
        
        return answer;
    }
}