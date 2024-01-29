import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> d = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                d.addFirst(num);
            } else if(command.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                d.addLast(num);
            } else if(command.equals("pop_front")) {
                if(d.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(d.pollFirst());
                }
            } else if(command.equals("pop_back")) {
                if(d.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(d.pollLast());
                }
            } else if(command.equals("size")) {
                System.out.println(d.size());
            } else if(command.equals("empty")) {
                if(d.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if(command.equals("front")) {
                if(d.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(d.peekFirst());
                }
            } else if(command.equals("back")) {
                if(d.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(d.peekLast());
                }
            }
        }
    }
}
