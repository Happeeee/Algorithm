import java.util.*;

public class Main {
    public static String solution(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String s = sc.next();
            System.out.println(solution(s));
        }
    }
}
