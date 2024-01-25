import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> s = new Stack<>();
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
                s.push(c);
            } else if(c == ')') {
                if(str.charAt(i - 1) == '(') {
                    s.pop();
                    sum += s.size();
                } else {
                    s.pop();
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
