import java.util.*;

class Solution {
    
    static char[][] charMaps;
    static boolean[][] visited;
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    static int h, w ;
    
    public static int[] solution(String[] maps) {
        // X는 바다
        // 숫자는 무인도, 상하좌우 땅들도 무인도
        // 칸에 적힌건 식량? 상하좌우 다 더하면 머물 day
        
        // map을 char[][]로 전환하고 BFS로 더하기
        // visited로 모든 영역 다 돌아 다녀야함
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        h = maps.length;
        w = maps[0].length();
        
        charMaps = new char[h][w];
        visited = new boolean[h][w];
        
        for(int i = 0 ; i < maps.length ; i ++){
            charMaps[i] = maps[i].toCharArray();
        }
        
        // BFS를 돌아야하는데 시작 점을 정해준 것이 아니라 다 탐색 해야 됨
        for(int i = 0 ; i < charMaps.length ; i ++){
            for(int j = 0 ; j < charMaps[0].length ; j++){
                // 방문하지 않고, 바다가 아닌 곳을 찾으면 그 좌표부터 탐색 시작
                if(!visited[i][j] && charMaps[i][j] != 'X'){
                    int sum = bfs(i, j);
                    answer.add(sum);
                }
            }
        }
        
        if(answer.size() == 0){
            answer.add(-1);
        }
        
        Collections.sort(answer);
        
        int[] result = new int[answer.size()];
        for(int i = 0 ; i<answer.size() ; i ++){
            result[i] = answer.get(i);
        }
        
        return result;
    }
    
    public static int bfs(int x, int y){
        int day = charMaps[x][y] - '0';
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
       
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            
            for(int i = 0 ; i < 4 ; i ++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx >= 0 && nx < h && ny >= 0 && ny < w){
                    if(!visited[nx][ny] && charMaps[nx][ny] != 'X'){
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                        day += charMaps[nx][ny] - '0';
                    }
                }
            }
        }
        
        return day;
    }
}