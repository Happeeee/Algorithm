import java.util.*;

public class Main {
    public static int solution(int[] arr,int n, int m) {
        int result = 0, lt = 0, sum = 0;
        for(int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if(sum == m) result++;
            while(sum >= m) {
                sum -= arr[lt++];
                if(sum == m) result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(solution(arr, n, m));
    }
}
