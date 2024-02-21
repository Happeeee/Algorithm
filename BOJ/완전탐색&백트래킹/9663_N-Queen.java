import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    static int n;
    static int count;

    public static boolean canGo(int col) {
        for(int i = 0; i < col; i++) {
            if(arr[col] == arr[i]) {
                return false;
            }
            if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public static void solve(int depth) {
        if(depth == n) {
            count++;
            return;
        }

        for(int row = 0; row < n; row++) {
            arr[depth] = row;
            if(canGo(depth)) {
                solve(depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        solve(0);
        System.out.println(count);
    }
}
