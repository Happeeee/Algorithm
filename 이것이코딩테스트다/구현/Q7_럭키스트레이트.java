import java.util.*;

public class Main {	
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n = sc.nextLine();
		
		int left = 0, right = 0;
		int mid = n.length() / 2;		
		
		for(int i = 0; i < n.length(); i++) {
			if(i < mid)
				left += n.charAt(i) - '0';
			else
				right += n.charAt(i) - '0';
		}
		
		if(left == right)
			System.out.println("LUCKY");
		else
			System.out.println("READY");				
	}
}
