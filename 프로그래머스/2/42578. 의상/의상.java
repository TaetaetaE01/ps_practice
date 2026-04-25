import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 맵에 옷 종류, 종류별 개수를 해서 각각 하나씩만 입을 수도 있고, 아예안입는 경우의 수를 구하면 됨
        
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        // 옷 type 별로 세팅해줌
        for(String[] clothe : clothes){
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }
        
        Iterator<Integer> it = map.values().iterator();
        while(it.hasNext()){
            // +1은 입지 않는 경우의 수 각각
            answer *= it.next() + 1;
        }
        return answer - 1 ;
    }
}