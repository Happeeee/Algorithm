import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		StringTokenizer st;
		
		String command;
		int n, last = 0;
		
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			command = st.nextToken();
			
			switch(command) {
			case "push" :
				last = Integer.parseInt(st.nextToken());
				queue.add(last);				
				break;
			case "pop" :
				if(queue.size() == 0) {
					System.out.println(-1);
					continue;
				}
				
				System.out.println(queue.poll());
				break;
			case "size" :
				System.out.println(queue.size());
				break;
			case "empty" :
				if(queue.isEmpty())
					System.out.println(1);
				else 
					System.out.println(0);			
				break;
			case "front" :
				if(queue.size() == 0) {
					System.out.println(-1);
					continue;
				}
					
				System.out.println(queue.peek());
				break;
			case "back" :
				if(queue.size() == 0) {
					System.out.println(-1);
					continue;
				}
				
				System.out.println(last);
				break;										
			}
		}
		
		
	}
}
