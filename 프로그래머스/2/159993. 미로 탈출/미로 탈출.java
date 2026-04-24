import java.util.*;

class Solution {
    
    char[][] charMaps;
    
    int w,h;
    
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    public int solution(String[] maps) {
        // s -> l 까지 최단 + l -> e 최단 더하면 되는 거 아님?
        // s랑 l 지점을 전체에서 찾아야함.
        
        int answer = 0;
        
        w = maps[0].length();
        h = maps.length;
        
        charMaps = new char[h][w];
        
        for(int i = 0 ; i < h ; i ++){
            charMaps[i] = maps[i].toCharArray();
        }
        
        int lever = 0;
        int exit = 0;
        for(int i = 0 ; i < h ; i++){
            for(int j = 0 ; j < w ; j++){
                if(charMaps[i][j] == 'S'){
                    lever += bfs(i,j, 'L');
                }
            }
        }
        
        for(int i = 0 ; i < h ; i++){
            for(int j = 0 ; j < w ; j++){
                if(charMaps[i][j] == 'L'){
                    exit += bfs(i,j, 'E');
                }
            }
        }
        
        if(lever == -1 || exit == -1){
            return -1;
        }
        answer = lever + exit;
        return answer;
    }
    
    public int bfs(int startX, int startY, char destination){
        boolean[][] visited = new boolean[h][w];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0});
        
        visited[startX][startY] = true;
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];   
            int time = current[2];
            
            if(charMaps[cx][cy] == destination){
                return time;
            }
            
            for(int i = 0 ; i < 4 ; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >= 0 && nx < h && ny >= 0 && ny < w){
                    if(!visited[nx][ny] && charMaps[nx][ny] != 'X'){
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny, time + 1});
                    }
                }
            }
        }
        return -1;
    }
}