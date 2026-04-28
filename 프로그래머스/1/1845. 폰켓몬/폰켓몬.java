import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int pickCount = nums.length/2;
        
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        answer = Math.min(pickCount, set.size());
        
        return answer;
    }
}