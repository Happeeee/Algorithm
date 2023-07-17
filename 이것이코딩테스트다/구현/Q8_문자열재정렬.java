import java.util.*;

public class Main {	
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Character> list = new ArrayList<>();		
		int sum = 0;
		
		String str = sc.nextLine();
		
		for(char c : str.toCharArray()) {
			if(Character.isDigit(c))
				sum += c - '0';
			else
				list.add(c);
		}
		
		Collections.sort(list);
		
		for(char c : list)
			System.out.print(c);
		
		if(sum != 0)
			System.out.println(sum);		
	}
}
