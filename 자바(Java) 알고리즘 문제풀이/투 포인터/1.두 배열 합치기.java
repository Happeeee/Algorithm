import java.util.*;

public class Main {
    public static int[] solution(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int p1 = 0, p2 = 0, pr = 0;
        while(p1 < arr1.length && p2 < arr2.length) {
            if(arr1[p1] <= arr2[p2]) result[pr++] = arr1[p1++];
            else if(arr1[p1] > arr2[p2]) result[pr++] = arr2[p2++];
        }

        while(p1 < arr1.length) result[pr++] = arr1[p1++];
        while(p2 < arr2.length) result[pr++] = arr2[p2++];

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        for(int i : solution(arr1, arr2)) System.out.print(i + " ");
    }
}
