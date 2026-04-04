class Solution {
    
    static boolean visit[];
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        
        return answer;
    }
    
    // depth : 방문한 던전 수 , k : 현재 피로도
    public void dfs(int depth, int k, int[][] dungeons){
        answer = Math.max(answer, depth);
        
        for(int i = 0 ; i < dungeons.length ; i++){
            if(visit[i] == false && dungeons[i][0] <= k){
                visit[i] = true;
                
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }
    }
}