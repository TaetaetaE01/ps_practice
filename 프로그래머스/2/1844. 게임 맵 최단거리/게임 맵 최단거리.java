import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int n,m;
    
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        answer = bfs(0,0, maps);
        
        return answer;
    }
    
    public int bfs(int startX, int startY, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 1});
        visited[startX][startY] = true;
        
        while(!q.isEmpty()){
            int current[] = q.poll();
            int cx = current[0];
            int cy = current[1];
            
            // 끝 지점에 도착하면 그때 동안 간 count를 리턴
            if(cx == n-1 && cy == m-1){
                return current[2];
            }
            
            for(int i = 0 ; i < 4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(maps[nx][ny] == 1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny, current[2] + 1});
                    }
                }
            }
        }
        return -1;
    }
}