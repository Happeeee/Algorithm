import java.util.*;

public class Main {
    public static int[] solution(int[] arr) {
        int[] rank = new int[arr.length];
        Arrays.fill(rank, 1);
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(arr[i] > arr[j]) rank[j]++;
            }
        }
        return rank;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for(int i : solution(arr)) System.out.print(i + " ");
    }
}
