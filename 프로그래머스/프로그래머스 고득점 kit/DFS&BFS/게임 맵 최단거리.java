import java.util.*;

class Solution {
    private int[][] maps;
    private int[][] visited; 
    private int n, m;
    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {-1, 1, 0, 0};
    
    private class Point {
        int y;
        int x;
        
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    private void bfs(int y, int x) {
        Queue<Point> q = new LinkedList<>();
        
        visited[y][x] = 1;
        q.add(new Point(y, x));
        
        while(!q.isEmpty()) {
            Point p = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
            
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(maps[ny][nx] == 0 || visited[ny][nx] != 0) continue;
                visited[ny][nx] = visited[p.y][p.x] + 1;
                q.add(new Point(ny, nx));
            }            
        }                 
    }
    
    public int solution(int[][] maps) {
        this.maps = maps;
        this.n = maps.length;
        this.m = maps[0].length;
        this.visited = new int[n][m];
        
        bfs(0, 0);
        
        if(visited[n - 1][m - 1] == 0) return -1;
        else return visited[n - 1][m - 1];
    }
}
