import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // board에서 move 정보에 따른 맨 위의 인형을 찾아 스택에 넣는다 
        // 스택에 넣을 때 같은인형이 2개일 경우 pop한다
        int answer = 0;
        
        Deque<Integer> basket = new ArrayDeque<>();
        
        for(int i = 0 ; i < moves.length ; i ++){
            int pick = moves[i] - 1;
            for(int j = 0 ; j < board.length ; j++){
                if(board[j][pick] != 0){
                    int doll = board[j][pick];
                    board[j][pick] = 0;
                    
                    if(!basket.isEmpty() && basket.peek() == doll){
                        basket.pop();
                        answer += 2;
                    } else{
                        basket.push(doll);
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
}