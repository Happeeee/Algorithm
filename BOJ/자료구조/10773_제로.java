import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();

        int sum = 0;
        for(int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n != 0) {
                s.push(n);
                sum += n;
            } else {
                sum -= s.pop();
            }
        }

        System.out.println(sum);
    }
}
