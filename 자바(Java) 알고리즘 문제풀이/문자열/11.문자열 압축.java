import java.util.*;

public class Main {
    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        int count = 0;

        for(char c : s.toCharArray()) {
            if(prev == c) count++;
            else {
                sb.append(prev);
                if(count > 1) sb.append(count);
                prev = c;
                count = 1;
            }
        }

        sb.append(prev);
        if(count > 1) sb.append(count);

        return sb.toString();
    }
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solution(s));
    }
}
