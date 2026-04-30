import java.util.*;

class Solution {
    boolean solution(String s) {
        // 스택에서 괄호가 열렀으면 닫히는게 나와야하고, 안나오면 안됨 열리는 괄호가 연속으로 나오는 건 count따로 체크 - X
        // 문자열에서 여는 괄호가 나오면 스택에 넣고 닫히면 스택에서 뺀다.
        boolean answer = true;
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0 ; i < s.length(); i ++ ){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            } else if (c == ')') {
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
       
        // 스택이 비면 괄호의 짝이 다 맞은 경우니깐 true
        // 스택에 하나라도 뭐가 들어가있으면 아직 괄호가 다 안닫힌거니깐 false
        return stack.isEmpty();
    }
}