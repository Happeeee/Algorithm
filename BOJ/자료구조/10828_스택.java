import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                s.push(num);
            }
            if(command.equals("pop")) {
                if(s.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(s.pop());
                }
            }
            if(command.equals("size")) {
                System.out.println(s.size());
            }
            if(command.equals("empty")) {
                if(s.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
            if(command.equals("top")) {
                if(s.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(s.peek());
                }
            }
        }
    }
}
