import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }

    private static int solution(String str) {
        Stack<Integer> s = new Stack<>();
        for(char c : str.toCharArray()) {
            if(Character.isDigit(c)) {
                s.push(c - '0');
            } else {
                int n1 = s.pop();
                int n2 = s.pop();
                if(c == '+') {
                    s.push(n2 + n1);
                } else if(c == '-') {
                    s.push(n2 - n1);
                } else if(c == '*') {
                    s.push(n2 * n1);
                } else if(c == '/') {
                    s.push(n2 / n1);
                }
            }
        }
        return s.pop();
    }
}
