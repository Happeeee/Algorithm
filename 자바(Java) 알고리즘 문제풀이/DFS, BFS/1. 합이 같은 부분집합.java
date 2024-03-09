import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int totalSum;
    static boolean answer = false;
    static int[] arr;

    public static void dfs(int idx, int sum) {
        if(idx == n) {
            if(sum == totalSum - sum) {
                answer = true;
            }
            return;
        }

        if(!answer) {
            dfs(idx + 1, sum + arr[idx]);
            dfs(idx + 1, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            totalSum += arr[i];
        }

        dfs(0, 0);

        if(answer) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
