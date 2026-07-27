import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];
        
        for(int i = 0 ; i < commands.length ; i ++){
            // 시작 인덱스는 포함, 끝 인덱스는 미포함
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] -1];
        }
        return answer;
    }
}