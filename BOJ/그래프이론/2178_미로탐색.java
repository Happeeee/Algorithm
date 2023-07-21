import java.util.*;

public class Main {
	private static int[][] map = new int[100][100];
	private static int[][] visited = new int[100][100];
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {-1, 1, 0, 0};	
	private static int n, m;
	
	private static class Pos {
		int y; 
		int x;
		
		private Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	private static void bfs(int y, int x) {
		Queue<Pos> q = new LinkedList<>();
		visited[y][x] = 1;
		q.add(new Pos(y, x));
		
		while(!q.isEmpty()) {
			Pos here = q.poll();			
			
			for(int i = 0; i < 4; i++) {
				int ny = here.y + dy[i];
				int nx = here.x + dx[i];
				
				if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
				if(map[ny][nx] == 0 || visited[ny][nx] != 0) continue;
				
				visited[ny][nx] = visited[here.y][here.x] + 1;
				q.add(new Pos(ny, nx));				
			}			
		}		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < n; i++ ) {
			String str = sc.nextLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
		
		System.out.println(visited[n - 1][m - 1]);
	}
}


