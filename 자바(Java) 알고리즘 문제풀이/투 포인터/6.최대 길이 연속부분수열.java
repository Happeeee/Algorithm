import java.util.*;

public class Main {
    public static int solution(int[] arr, int n, int k) {
        int lt = 0, count = 0, max = 0;
        for(int rt = 0; rt < n; rt++) {
            if(arr[rt] == 0) count++; // 0 -> 1
            while(count > k) {
                if(arr[lt] == 0) count--; // 1 -> 0
                lt++;
            }
            max = Math.max(max, rt - lt + 1);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(solution(arr, n, k));
    }
}
