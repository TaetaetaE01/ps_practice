import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // terms : 약관종류, 유효기간
        // privacies : (i+1 번), 날짜, 약관종류
        // result : 파기해야하는 개인정보 번호 
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        
        StringTokenizer st;
        for(String term : terms){
            st = new StringTokenizer(term);
            String type = st.nextToken();
            Integer period = Integer.parseInt(st.nextToken());
            
            termMap.put(type, period);
        }
        
        int todayDate = getDate(today);
        for(int i = 0 ; i < privacies.length ; i++ ){
            String privacy = privacies[i];
            st = new StringTokenizer(privacy);
            String day = st.nextToken();
            String type = st.nextToken();
            
            int privacyDate = getDate(day);
            int termDate = termMap.get(type) * 28;
            
            int temp = todayDate - privacyDate;
            if(temp >= termDate){
                answer.add(i+1);
            }
        }
        
        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
    
    public int getDate(String checkDay){
        String[] arr = checkDay.split("\\.");
        
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        
        return (year * 12 * 28) + (month * 28) + day;
    }
}