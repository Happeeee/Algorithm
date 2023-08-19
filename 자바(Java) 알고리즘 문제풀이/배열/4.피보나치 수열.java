import java.util.*;

public class Main {
    public static int[] solution(int n) {
        int[] arr = new int[n];
        arr[0] = 1; arr[1] = 1;

        for(int i = 2; i < n; i++)
            arr[i] = arr[i - 1] + arr[i - 2];
        
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i : solution(n))
            System.out.print(i + " ");
    }
}
