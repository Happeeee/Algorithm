import java.util.*;

public class Main {
    public static int solution(int[] arr) {
        int plus = 0;
        int result = 0;
        for(int i : arr) {
            if(i == 1) result += ++plus;
            else plus = 0;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(solution(arr));
    }
}
