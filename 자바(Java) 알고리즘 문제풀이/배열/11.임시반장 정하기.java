import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int solution(int[][] arr, int n) {
        int max = -1;
        int reader = -1;

        for(int i = 1; i <= n; i++) {
            int count = 0;
            for(int j = 1; j <= n; j++) {
                if(i == j) continue;
                for(int k = 1; k <= 5; k++) {
                    if(arr[i][k] == arr[j][k]) {
                        count++;
                        break;
                    }
                }
            }
            if(max < count) {
                max = count;
                reader = i;
            }
        }
        return reader;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][6];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(arr, n));
    }
}
