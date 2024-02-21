import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static int solve(int[][] arr, int n) {
        int count = 1;
        int prev_end = arr[0][1];
        for(int i = 1; i < n; i++) {
            if(arr[i][0] >= prev_end) {
                count++;
                prev_end = arr[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i][0] = start;
            arr[i][1] = end;
        }

        Arrays.sort(arr, comp);
        System.out.println(solve(arr, n));
    }

    public static Comparator<int[]> comp = new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            if(a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1]- b[1];
        }
    };
}
