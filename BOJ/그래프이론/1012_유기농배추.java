import java.util.*;

public class Main {
	
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {-1, 1, 0, 0};
	
	private static void dfs(int y, int x, int n, int m, int[][] map) {
		map[y][x] = 0; // 방문처리
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
			if(map[ny][nx] == 0) continue;
			
			dfs(ny, nx, n, m, map);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t, n, m, k, x, y;
		
		t = sc.nextInt();
		
		while(t-- > 0) {
			int[][] map = new int[50][50];
			m = sc.nextInt(); // 가로
			n = sc.nextInt(); // 세로
			k = sc.nextInt(); // 배추 수
			
			for(int i = 0; i < k ; i++) {
				x = sc.nextInt(); // 가로
				y = sc.nextInt(); // 세로
				
				map[y][x] = 1;
			}			
					
			int count = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] != 0) {
						dfs(i, j, n, m, map);
						count++;
					}						
				}
			}
			
			System.out.println(count);
		}
	}
}


