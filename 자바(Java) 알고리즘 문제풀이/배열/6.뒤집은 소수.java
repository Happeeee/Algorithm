import java.util.*;

public class Main {
    public static boolean isPrime(int n) {
        if(n == 1) return false;
        if(n == 2) return true;
        for(int i = 2; i * i <= n; i++)
            if(n % i == 0) return false;
        return true;
    }
    public static List<Integer> solution(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            int n = Integer.parseInt(new StringBuilder().append(arr[i]).reverse().toString());
            if(isPrime(n)) list.add(n);
        }

        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for(int i : solution(arr))
            System.out.print(i + " ");
    }
}

// 직접 뒤집기
// public static List<Integer> solution(int[] arr) {
//     List<Integer> list = new ArrayList<>();

//     for(int i = 0; i < arr.length; i++) {
//         int temp = arr[i];
//         int reverse = 0;
//         while(temp > 0) {
//             int r = temp % 10;
//             reverse = reverse * 10 + r;
//             temp = temp / 10;
//         }
//         if(isPrime(reverse)) list.add(reverse);
//     }

//     return list;
// }

