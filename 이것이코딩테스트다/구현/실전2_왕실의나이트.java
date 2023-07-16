import java.util.*;

public class Main {
	private static final int[] dx = {-1, 1, -1, 1, -2, -2, 2, 2}; // 상, 하, 좌, 우
	private static final int[] dy = {-2, -2, 2, 2, 1, -1, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pos = sc.nextLine();
		
		int x = pos.charAt(0) - 'a' + 1;
		int y = pos.charAt(1) - '0';				
		int count = 0;
		
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 1 && nx <=8 && ny >= 1 && ny <= 8)
				count++;
		}
		
		System.out.println(count);
		
	}
}
