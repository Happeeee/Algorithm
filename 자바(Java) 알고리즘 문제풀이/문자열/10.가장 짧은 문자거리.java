import java.util.*;

public class Main {
    public static int[] solution(String s, char c) {
        int[] arr = new int[s.length()];

        int p = 101;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c) p = 0;
            arr[i] = p++;
        }

        p = 101;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == c) p = 0;
            arr[i] = Math.min(arr[i], p++);
        }

        return arr;
    }
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char c = sc.next().charAt(0);

        for(int i : solution(s, c)) System.out.print(i + " ");
    }
}


// public class Main {
//     public static int[] solution(String s, char c) {
//         int[] arr = new int[s.length()];
//         Arrays.fill(arr, 101);

//         for(int i = 0; i < s.length(); i++) {
//             if(s.charAt(i) == c) {
//                 for(int j = 0; j < s.length(); j++) {
//                     if(s.charAt(j) == c) arr[j] = 0;
//                     else arr[j] = Math.min(arr[j], Math.abs(j - i));
//                 }
//             }
//         }
//         return arr;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String s = sc.next();
//         char c = sc.next().charAt(0);

//         for(int i : solution(s, c)) System.out.print(i + " ");
//     }
// }
