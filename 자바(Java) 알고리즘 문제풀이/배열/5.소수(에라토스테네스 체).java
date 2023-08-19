import java.util.*;

public class Main {
    public static int solution(int n) {
        int[] era = new int[n + 1];
        for(int i = 2; i <= n; i++) {
            if(era[i] == 1) continue;
            for(int j = i * 2; j <= n; j += i) {
                era[j] = 1;
            }
        }

        int count = 0;
        for(int i = 2; i <= n; i++)
            if(era[i] == 0) count++;
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}

// public class Main {
//     public static boolean isPrime(int n) {
//         if(n == 2) return true;
//         for(int i = 2; i * i <= n; i++) {
//             if(n % i == 0) return false;
//         }
//         return true;
//     }
//     public static int countPrime(int n) {
//         int count = 0;
//         for(int i = 2; i <= n; i++) {
//             if(isPrime(i)) count++;
//         }
//         return count;
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         System.out.println(countPrime(n));
//     }
// }
