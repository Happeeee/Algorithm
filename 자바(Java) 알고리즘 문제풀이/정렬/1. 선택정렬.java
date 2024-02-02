import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        for(int i : solution(n, arr)) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(int n, int[] arr) {
        for(int i = 0; i < n - 1; i++) {
            int minValue = arr[i];
            int minIndex = i;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < minValue) {
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
