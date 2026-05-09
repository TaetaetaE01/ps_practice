import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // fees : 기본시간(분), 기본요금, 추가시간(분), 추가요금
        
        int[] answer = {};
        
        // 입차 기록을 확인함
        Map<String, Integer> map = new HashMap<>();
        // 차번호별 누적 시간
        Map<String, Integer> timeMap = new TreeMap<>();
        
        StringTokenizer st;
        for(String record : records){
            st = new StringTokenizer(record);
            String time = st.nextToken();
            String carNum = st.nextToken();
            String type = st.nextToken();
            
            int minTime = getMin(time);
            
            if(type.equals("IN")){
                map.put(carNum, minTime);
            } else {
                int inTime = map.get(carNum);
                int parkedTime = minTime - inTime;
                timeMap.put(carNum, timeMap.getOrDefault(carNum, 0) + parkedTime);
                
                map.remove(carNum);
            }
        }
        
        int endTime = getMin("23:59");
        for(String carNum : map.keySet()){
            int inTime = map.get(carNum);
            int parkedTime = endTime - inTime;
            timeMap.put(carNum, timeMap.getOrDefault(carNum, 0) + parkedTime);
            
        }
        
        answer = new int[timeMap.size()];
        int index = 0;
        for(int parkedTime : timeMap.values()){
            int cost = calCost(parkedTime, fees);
            answer[index++] = cost;
        }
        
        return answer;
    }
    
    private int getMin(String time){
        String[] parts = time.split(":");
        
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);
        
        int minTime = hour * 60 + min;
        return minTime;
    }
    
    private int calCost(int parkedTime, int[] fees){
        int defaultTime = fees[0];
        int defaultCost = fees[1];
        int unitTime = fees[2];
        int unitCost = fees[3];
        
        if(parkedTime <= defaultTime){
            return defaultCost;
        } else {        
            int extraTime = parkedTime - defaultTime;
            int extraCost = (int) Math.ceil((double) extraTime / unitTime) * unitCost;
        
            return defaultCost + extraCost;
        }
    }
}