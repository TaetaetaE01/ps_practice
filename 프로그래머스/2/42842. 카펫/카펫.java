class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int w = 3 ; w <= sum ; w++){
            // 딱 나눠지지 않으면 격자가 안됨
            if(sum % w == 0){
                int h = sum / w;
                
                // 노란색은 가로, 세로 -2씩 한것의 합이기 때문
                if((w-2) * (h-2) == yellow){
                    answer[0] = w;
                    answer[1] = h;
                }
            }
        }
        
        return answer;
    }
}