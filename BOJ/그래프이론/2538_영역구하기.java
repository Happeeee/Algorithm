import java.util.*;

public class Main { 
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    
    private static int[][] map = new int[100][100];
    private static boolean[][] visited = new boolean[100][100];
    private static int m, n, k;
    
    private static int dfs(int y, int x, int depth) {
        visited[y][x] = true;
        depth++;
        
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
            if(map[ny][nx] == 1 || visited[ny][nx]) continue;
            depth = dfs(ny, nx, depth);
        }
        
        return depth;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        
        int y1, x1, y2, x2;
        
        while(k-- > 0) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            
            for(int i = y1; i < y2; i++) {
                for(int j = x1; j < x2; j++) {
                    map[i][j] = 1;
                }
            }
        }        
                
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    list.add(dfs(i, j, 0));    
                    count++;
                }
            }
        }
        
        Collections.sort(list);
                
        System.out.println(count);
        
        for(int i : list) 
            System.out.print(i + " ");
        
                           
    }
}
