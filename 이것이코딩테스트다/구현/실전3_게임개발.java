import java.util.*;

public class Main {	
	
	private static final int[] dx = {0, 1, 0, -1};
	private static final int[] dy = {-1, 0, 1, 0}; // 복 동 남 서
	
	private static int canGoDir(int dir, int x, int y, int[][] map) { // 4방향을 돌면서 갈 수 있는 방향이 있는지 검사하고 방향을 리턴	
		for(int i = 0; i < 4; i++) {
			dir = (dir + 3) % 4;
			
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(map[ny][nx] == 0 && ny < map.length && nx < map[0].length) { 
				return dir; 
			}					
		}		
		return -1; // 갈 수 있는 방향이 없음을 의미		
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int count = 0;
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		int[][] map = new int[row][col];

		int x = sc.nextInt();
		int y = sc.nextInt();
		int dir = sc.nextInt();			
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		map[y][x] = 2; // 현재 좌표 방문체크
		count++; // 방문 횟수 증가
		
		while(true) {
			if(canGoDir(dir, x, y, map) != -1) { // 갈 수 있는 방향이 있다면
				dir = canGoDir(dir, x, y, map); // 해당 방향으로 전환하고
				x += dx[dir]; // 이동
				y += dy[dir];
				
				map[y][x] = 2; // 방문체크				
				count++; // 방문 횟수 증가
			} else {				
				int nx = x + dx[(dir + 2) % 4];
				int ny = y + dy[(dir + 2) % 4]; // 갈 수 있는 방향이 없다면 한칸 뒤로 이동하는데				
				
				if(map[ny][nx] == 1) break; // 뒤가 바다라면 break;
				
				x = nx;
				y = ny;
			}
		}
		
		System.out.println(count);
	}
}
