import java.util.*;

public class Main {    
    public static int solution(int n) {
        int result = 0;
        int lt = 1;
        int sum = 0;
        for(int rt = 1; rt <= n / 2 + 1; rt++) {
            sum += rt;
            if(sum == n) result++;
            while(sum >= n) {
                sum -= lt++;
                if(sum == n) result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
