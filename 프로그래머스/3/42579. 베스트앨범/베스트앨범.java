import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별로 재생된 수를 더한 맵(가장 큰 값 찾기가 우선순위 1번) -> 정렬해야 됨
        // 장르별로 고유번호를 가진 조회수를 포함한 맵 -> 정렬해야됨
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 장르, 재생합 -> 재생횟수로
        Map<String, Integer> sumPlaysMap = new HashMap<>();
        // 장르, 고유번호, 재생횟수 -> 정렬은 재생횟수로
        Map<String, Map<Integer, Integer>> musicMap = new HashMap<>();
        
        for(int i = 0 ; i < genres.length ; i ++){
            // 장르가 들어오지 않은 경우
            if(!sumPlaysMap.containsKey(genres[i])){
                // 장르별 재생을 넣어준다
                sumPlaysMap.put(genres[i], plays[i]);
                
                // 장르별 고유번호, 재생횟수
                Map<Integer, Integer> music = new HashMap<>();
                music.put(i, plays[i]);
            
                musicMap.put(genres[i], music);
            } else{
                // 장르가 들어와있는경우 music의 메모리를 살려야함
                // 기존 장르의 value를 가져와서 +해줌
                sumPlaysMap.put(genres[i], sumPlaysMap.get(genres[i]) + plays[i]);
                
                musicMap.get(genres[i]).put(i, plays[i]);
            }
        }
        
            // 장르별 재생합 정렬
            List<String> keySet = new ArrayList<>(sumPlaysMap.keySet());
            keySet.sort((g1, g2) -> sumPlaysMap.get(g2) - sumPlaysMap.get(g1));
            
            for(String genre : keySet){
                // 정렬된 musicMap
                Map<Integer, Integer> map = musicMap.get(genre);
                List<Integer> playKeySet = new ArrayList<>(map.keySet());
                
                playKeySet.sort((k1, k2) ->{
                    // 고유번호 정렬
                    if(map.get(k1).equals(map.get(k2))){
                        return k1 - k2;
                    }
                    // 재생횟수 정렬
                    return map.get(k2) - map.get(k1);
                });
                
                answer.add(playKeySet.get(0));
                if(playKeySet.size() > 1){
                    answer.add(playKeySet.get(1));
                }
            }                             
        
        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}