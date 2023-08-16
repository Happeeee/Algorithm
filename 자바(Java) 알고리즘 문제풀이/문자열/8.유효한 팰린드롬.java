import java.util.*;

public class Main {
    public static boolean solution(String str) {
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        return new StringBuilder(str).reverse().toString().equals(str);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(solution(str)) System.out.println("YES");
        else System.out.println("NO");
    }
}

// 알파벳만 sb로 직접 옮겨서 비교
// public class Main {
//     public static boolean solution(String str) {
//         StringBuilder sb = new StringBuilder();
//         for(char c : str.toCharArray())
//             if(Character.isAlphabetic(c)) sb.append(c);
//         return sb.toString().equalsIgnoreCase(sb.reverse().toString());
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String str = sc.nextLine();
//         if(solution(str)) System.out.println("YES");
//         else System.out.println("NO");
//     }
// }
