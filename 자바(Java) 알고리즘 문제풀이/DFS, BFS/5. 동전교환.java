import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, min = Integer.MAX_VALUE;
    static int[] arr;

    public static void dfs(int money, int count) {
        if(money < 0 || count >= min) return;
        if(money == 0) {
            min = Math.min(min, count);
            return;
        }
        for(int i = n - 1; i >= 0; i--) {
            dfs(money - arr[i], count + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        dfs(m, 0);
        System.out.println(min);
    }
}
