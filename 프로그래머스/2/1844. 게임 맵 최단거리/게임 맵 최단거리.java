import java.util.*;

class Solution {
    
    boolean visited[][];
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int n, m;
    
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
    
        visited = new boolean[n][m];
        
        answer = bfs(0,0,maps);
        
        return answer;
    }
    
    public int bfs(int startX, int startY, int[][] maps){
        // 첫 시작 노드를 큐에 넣어야함
        // 이후 근처 노드를 탐색한 후 조건에 맞으면(벽이 없으면) +1하여 앞으로 전진
        // 방문한 노드는 true로 재방문 못하게 해줘야함
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {startX, startY, 1});
        visited[startX][startY] = true;
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            int distance = current[2];
            
            // 끝에 도착하면 그때 동안 간 거리 return
            if(cx == n - 1 && cy == m -1){
                return distance;
            }
            
            for(int i = 0 ; i < 4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                // 갈림길에서 두 길의 정보가 queue에 들어간다
                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(maps[nx][ny] == 1 && visited[nx][ny] == false){
                        q.add(new int[] {nx, ny, distance + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}