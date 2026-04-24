class Solution {
    
    int count;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(0, numbers, target, 0);
        answer = count;
        return answer;
    }
    
    public void dfs(int currentIndex, int[] numbers, int target, int sum){
        if(currentIndex == numbers.length){
            if(target == sum){
                count++;
            }
            return;
        }
        dfs(currentIndex + 1, numbers, target, sum + numbers[currentIndex]);
        dfs(currentIndex + 1, numbers, target, sum - numbers[currentIndex]);
    }
}