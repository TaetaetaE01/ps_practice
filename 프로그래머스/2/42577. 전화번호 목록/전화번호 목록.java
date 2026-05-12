import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 전화번호 리스트에서 접두사가 겹치는게 하나라도 있으면 false, 아니면 ture 반환
        // 겹치는게 여러개 인건 신경 안써도 되서, 하나라도 발견되면 return
        boolean answer = true;
        
        Map<String, Integer> map = new HashMap<>();
        for(String phoneNum : phone_book){
            // Key 값만 중요하고 뒤에 1은 의미 없음
            map.put(phoneNum, 1);
        }
        
        for(int i = 0 ; i < phone_book.length ; i ++){
            String phoneNum = phone_book[i];
            
            for(int j = 1 ; j < phoneNum.length() ; j ++){
                String prefix = phoneNum.substring(0, j);
                
                if(map.containsKey(prefix)){
                    return false;
                }
            }
        }
        
        
        return answer;
    }
}