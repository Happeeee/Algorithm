import java.util.*;

public class Main {
    public static String solution(String str) {
        String answer = "";
        for(char c : str.toCharArray()) {
            if(answer.indexOf(c) == -1)
                answer += c;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
