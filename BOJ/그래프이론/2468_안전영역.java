package Ps;

import java.util.*;

public class Main {     
    private static int[][] map = new int[100][100];
    private static boolean[][] visited = new boolean[100][100]; 
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int n;
    
    private static void dfs(int y, int x, int height) {
        visited[y][x] = true;
        
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
            if(map[ny][nx] <= height || visited[ny][nx]) continue; // 방문된적 있거나 잠겼으면 continue
            
            dfs(ny, nx, height);
        }       
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        n = sc.nextInt();
        
        int maxHeight = -1; // map에서 가장 높은 높이
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n ; j++) {
                map[i][j] = sc.nextInt();
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }
                    
        int result = -1; // 안전한 영역의 최대 개수
        while(maxHeight-- > 0) {
            for(int i = 0; i < 100; i++) 
                Arrays.fill(visited[i], false);
            
            int count = 0; // 높이별 안전한 영역의 수
                        
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] > maxHeight && !visited[i][j]) { // 방문된적 없고 안잠겼으면 dfs                  
                        dfs(i, j, maxHeight);
                        count++;
                    }                   
                }
            }
            
            result = Math.max(result, count);
        }
        
        System.out.println(result);
                        
    }
}


