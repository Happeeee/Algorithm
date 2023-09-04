import java.util.*;

public class Main {
    public static int solution(int[] arr,int k) {
        int max = 0, sum = 0;
        int start = 0, end = k - 1;

        for(int i = 0; i < k; i++)
            sum += arr[i];

        max = sum;

        while(end < arr.length - 1) {
            sum -= arr[start++];
            sum += arr[++end];
            if(max < sum) max = sum;
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

        System.out.println(solution(arr, k));
    }
}
