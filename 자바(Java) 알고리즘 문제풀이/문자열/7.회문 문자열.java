import java.util.*;

public class Main {
    public static boolean solution(String str) {
        str = str.toLowerCase();
        return new StringBuilder(str).reverse().toString().equals(str);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(solution(str)) System.out.println("YES");
        else System.out.println("NO");
    }
}
