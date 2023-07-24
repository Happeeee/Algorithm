import java.util.*;

public class Main {
    private static int distance(int apple, int basket, int basketEnd) {
        if(apple >= basket && apple <= basketEnd) return 0;
        if(apple < basket) return apple - basket;
        if(apple > basketEnd) return apple - basketEnd;

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, j, sum = 0;

        n = sc.nextInt();
        m = sc.nextInt();
        j = sc.nextInt();

        int basket = 1;
        int basketEnd = basket + m - 1;

        for(int i = 0; i < j; i++) {
            int apple = sc.nextInt();
            int distance = distance(apple, basket, basketEnd);

            sum += Math.abs(distance);
            basket += distance;
            basketEnd += distance;
        }

        System.out.println(sum);

    }
}
