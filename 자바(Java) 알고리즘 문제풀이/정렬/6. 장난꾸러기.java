import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i : solution(arr, n)) {
            System.out.print(i + " ");
        }
    }

    private static ArrayList<Integer> solution(int[] arr, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] arr2 = Arrays.copyOf(arr, n);
        Arrays.sort(arr2);
        for(int i = 0; i < n; i++) {
            if(arr[i] != arr2[i]) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
