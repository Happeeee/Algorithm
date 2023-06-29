import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[5][15];
		
		String s;
		int row = 0, col;
		
		for(int i = 0; i < 5; i++) {
			s = sc.nextLine();
	
			col = 0;
			
			for(int j = 0; j < s.length(); j++, col++) {
				arr[row][col] = s.charAt(j);
			}
			
			row++;
		}
	
		for(int j = 0; j < 15; j++) {
			for(int i = 0; i < 5; i++) {
				if(arr[i][j] == '\0') continue;
				System.out.print(arr[i][j]);
			}
		}
		
		}

}
