import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int factorial(int n) {
        int result = 1;
        while(n > 0) {
            result *= n--;
        }
        return result;
    }

    public static int solve(int n, int k) {
        return factorial(n) / (factorial(n - k) * factorial(k));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(solve(n, k));
    }
}
