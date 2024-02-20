import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int count = 0;

    public static void solve(int n, int target) {
        int lt = 0;
        int rt = 0;
        int sum = 0;

        while(lt < n) {
            if(sum >= target) {
                sum -= arr[lt++];
            } else if(rt >= n) {
                break;
            } else {
                sum += arr[rt++];
            }
            if(sum == target) {
                count++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(n, m);

        System.out.println(count);
    }
}

