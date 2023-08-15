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

// reverse 직접 구현
// public class Main {
//     public static String solution(String s) {
//         char[] arr = s.toCharArray();
//         int lt = 0, rt = arr.length - 1;
//         while(lt < rt) {
//             char temp = arr[lt];
//             arr[lt] = arr[rt];
//             arr[rt] = temp;
//             lt++;
//             rt--;
//         }
//         return String.valueOf(arr);
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();

//         for(int i = 0; i < n; i++) {
//             String s = sc.next();
//             System.out.println(solution(s));
//         }
//     }
// }
