import java.util.*;

public class Main {
    public static String solution(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            s = s.replace("#", "1").replace("*", "0");
            sb.append((char)Integer.parseInt(s, 2));
        }
        return sb.toString();
    }
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        String s = sc.next();

        for(int i = 0; i < n; i++)
            arr[i] = s.substring(i * 7, (i + 1) * 7);

        System.out.println(solution(arr));
    }
}
