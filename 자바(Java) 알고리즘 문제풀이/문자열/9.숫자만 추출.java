import java.util.*;

public class Main {
    public static int solution(String str) {
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()) 
            if(Character.isDigit(c)) sb.append(c);
        return Integer.parseInt(sb.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}

// public class Main {
//     public static int solution(String str) {
//         int answer = 0;
//         for(char c : str.toCharArray()) {
//             if(Character.isDigit(c)) 
//                 answer = answer * 10 + c - '0';
//         }
//         return answer;
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String str = sc.next();
//         System.out.println(solution(str));
//     }
// }
