class Solution {
    
    static int[][] graph;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new int[n+1][n+1];
        
        for(int i = 0 ; i < wires.length ; i ++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            // 각 송전탑을 양방향으로 연결
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        
        for(int i = 0 ; i < wires.length ; i ++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            // 각 송전탑을 양방향 하나씩 끊기
            graph[v1][v2] = 0;
            graph[v2][v1] = 0;
            
            boolean visit[] = new boolean[n+1];
            
            int cnt = dfs(v1, visit, n);
            int diff = Math.abs(cnt -(n - cnt));
            answer = Math.min(diff, answer);
            
            // 다시 연결시켜 줘야 함 다음 송전탑기준으로 계산하기 위해서
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        
        return answer;
    }
    
    public int dfs(int v1, boolean[] visit, int n){
        visit[v1] = true;
        int count = 1;
        
        for(int i = 1 ; i <= n ; i ++){
            if(!visit[i] && graph[v1][i] == 1){
                count += dfs(i, visit, n);
            }
        }
        return count;
    }
}