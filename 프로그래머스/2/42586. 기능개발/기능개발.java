import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> deployment = new ArrayList<>();
        
        for(int i = 0 ; i < progresses.length ; i++){
            int leftTask = 100 - progresses[i];
            int speed = speeds[i];
            if(leftTask % speed == 0){
                q.offer(leftTask / speed);
            } else{
                q.offer((leftTask / speed) + 1);
            }
        }
        
        int day = q.poll();
        int count = 1;
        while(!q.isEmpty()){
            // 뒤에 작업의 배포날이 작으면 앞에 끝날 때 까지 기다려야함.
            if(day >= q.peek()){
                count++;
                q.poll(); // 비교 끝났으니 q에서 뺌
            } else {
                deployment.add(count);
                count = 1; // 넣었으니 리셋
                day = q.poll(); // 다시 새로운 day 기준으로
            }
        }
        deployment.add(count); // 위에서 poll한게 마지막 task일경우 리스트에 넣어줘야함
        
        answer = new int[deployment.size()];
        for(int i = 0 ; i < deployment.size() ; i ++){
            answer[i] = deployment.get(i);
        }
        
        return answer;
    }
}