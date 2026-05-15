import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // fees : 기본시간, 기본요금, 단위시간, 단위요금
        // records : 입출차 시간, 차량번호, type
        
        // 차량이 주차한 시간에 따라서 요금을 부여한다.
        // 기본 시간이하면 기본요금, 초과하면 단위시간 * 단위 요금 청구
        // 단위시간은 올림하여 계산
        
        // 들어온 차량은 있는데 나가는 기록이 없으면 23:59분에 나간 것
        // 맵으로 차량 누적 시간 확인
        // treeMap으로 차량번호 작은순 정렬, 아니면 keyList로 정렬
        
        // 누적시간으로 가지고 있고, 마지막에 answer에 돈계산
        
        // result : 차량별 누적 요금 금액
        // 차번호, 입차분 변환 시간
        Map<String, Integer> timeMap = new HashMap<>();
        // 차번호, 누적시간
        Map<String, Integer> costMap = new TreeMap<>();
        
        StringTokenizer st;
        for(String record : records){
            st = new StringTokenizer(record);
            String time = st.nextToken();
            String carNum = st.nextToken();
            String type = st.nextToken();
            
            int minTime = getMin(time);
            if(type.equals("IN")){
                timeMap.put(carNum, minTime);
            } else {
                int inTime = timeMap.get(carNum);
                int parkedTime = minTime - inTime;
                
                costMap.put(carNum, costMap.getOrDefault(carNum, 0) + parkedTime);
                timeMap.remove(carNum);
            }
        }
        
        int endTime = getMin("23:59");
        for(String carNum : timeMap.keySet()){
            int inTime = timeMap.get(carNum);
            int parkedTime = endTime - inTime;
                
            costMap.put(carNum, costMap.getOrDefault(carNum, 0) + parkedTime);
        }
        
        
        int[] answer = new int[costMap.size()];
        int index = 0;
        for(String key : costMap.keySet()){
            answer[index] = calCost(costMap.get(key), fees);
            index++;
        }
    
        return answer;
    }
    
    public int getMin(String time){
        String[] arr = time.split(":");
        int hour = Integer.parseInt(arr[0]);
        int minute = Integer.parseInt(arr[1]);
        
        return hour * 60 + minute;
    }
    
    public int calCost(int parkedTime, int[] fees){
        int defaultTime = fees[0];
        int defaultCost = fees[1];
        int unitTime = fees[2];
        int unitCost = fees[3];
        
        if(parkedTime < defaultTime){
            // 기본 요금
            return defaultCost;
        }
        
        // 기본요금 + 추가요금
        int overTime = parkedTime - defaultTime;
        int overCost = (int) Math.ceil ((double) overTime / unitTime) * unitCost;
        
        return defaultCost + overCost;
    }
}