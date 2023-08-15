import java.util.*;

public class Main {
    public static String solution(String str) {
        String answer = "";
        String[] arr = str.split(" ");

        for(String s : arr) {
            if(answer.length() < s.length()) {
                answer = s;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}

