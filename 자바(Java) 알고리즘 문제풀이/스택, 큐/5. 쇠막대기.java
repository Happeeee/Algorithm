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
        Stack<Character> s = new Stack<>();
        int sum = 0;
        char prev = ' ';
        for(char c : str.toCharArray()) {
            if(c == '(') {
                s.push(c);
            } else if (c == ')') {
                s.pop();
                if(prev == '(') {
                    sum += s.size();
                } else if(prev == ')') {
                    sum++;
                }
            }
            prev = c;
        }
        return sum;
    }
}
