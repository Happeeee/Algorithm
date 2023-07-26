import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int count2 = 0, count5 = 0;
            int n = sc.nextInt();

            for(int j = 2; j <= n; j *= 2) {
                count2 += n / j;
            }

            for(int j = 5; j <= n; j *= 5) {
                count5 += n / j;
            }

            System.out.println(Math.min(count2, count5));
        }
    }
}
