import java.util.*;

public class Main {
    public static int solution(int n) {
        int result = 0;
        for(int i = 2; i <= n / 2 + 1; i++) {
            int sum = 0;
            for(int j = 1; j <= i; j++)
                sum += j;          
            int remain = n - sum;
            if(remain < 0) break;
            if(remain % i == 0) result++;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}

// n을 직접 빼는 풀이
// public static int solution(int n) {
//     int result = 0, count = 1;
//     n--;
//     while(n > 0) {
//         count++;
//         n -= count;
//         if(n % count == 0) result++;
//     }
//     return result;
// }
