class Solution {
    
    boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visit = new boolean[n];
        for(int i = 0 ; i < n ; i ++){
            if(visit[i] == false){
                // dfs 탐색에서 중복 탐색이 안되도록 하기 위해
                answer++;
                dfs(i, n, computers);
            }
        }
        return answer;
    }
    
    public void dfs(int i , int n , int[][] computers){
        visit[i] = true;
        
        for(int j = 0; j < n ; j++){
            if(!visit[j] && computers[i][j] == 1){
                visit[j] = true;
                dfs(j, n, computers);
            }
        }
    }
}