import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;

    public static int combination(int n, int r) {
        if(r == 1 || r == n - 1) return n;
        if(n == r || r == 0) return 1;
        if(arr[n][r] != 0) return arr[n][r];

        return arr[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];

        System.out.println(combination(n, r));
    }
}
