class Solution {
    
    int[][] graph;
    
    public int solution(int n, int[][] wires) {
        // wires : 연결된 전선의 정보, wires.length는 전선의 개수
        // graph : 송전탑(node라 볼 수 있음)
        // n : 송전탑 개수
        // 전선 정보를 바탕으로 송전탑을 양방향으로 연결
        // 전선을 하나씩 끊어서 양 덩어리의 차(-)의 최솟값을 구해야함
        // 모든 전선을 끝까지 다 끊어보고 비교해야되서 DFS, for문으로 모두 탐색해야됨
        
        int answer = n;
        graph = new int[n+1][n+1]; // 송전탑 번호는 1번부터 시작이라
        
        // 송전탑 세팅
        for(int i = 0 ; i < wires.length ; i ++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            // 각 송전탑을 양방향으로 연결 : 1
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        
        // 각 전선마다 다 끊어보고 찾기
        for(int i = 0 ; i < wires.length ; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            // 송전탑 전선을 하나씩 끊기 : 0
            graph[v1][v2] = 0;
            graph[v2][v1] = 0;
            
            // 낮은번호의 송전탑에 연결된 개수 dfs로 찾기
            boolean[] visited = new boolean[n+1];
            
            int count = dfs(v1, visited, n);
            int temp = Math.abs(count -(n-count));
            answer = Math.min(answer, temp);
            
            // 송전탑 다시 연결시켜서 초기화 시켜줘야 함
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        
        return answer;
    }
    
    public int dfs(int v1, boolean[] visited, int n){
        // 자기 자신 송전탑 개수는 포함
        int count = 1;
        visited[v1] = true;
        
        // 송전탑 기준으로 돌 탐색할 것이기 때문
        for(int i = 1; i <= n ; i ++){
            // 끊어진 송전탑 기준으로 주위 송전탑 개수 탐색
            if(graph[v1][i] == 1 && !visited[i]){
                count += dfs(i, visited, n);
            }
        }
        return count;
    }
}