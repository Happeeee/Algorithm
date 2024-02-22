import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static long solve(long[] cost, long[] price, int n) {
        for(int i = 1; i < n; i++) {
            if(price[i] > price[i - 1]) {
                price[i] = price[i - 1];
            }
        }

        long totalCost = 0;
        for(int i = 0; i < n - 1; i++) {
            totalCost += price[i] * cost[i];
        }
        return totalCost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] cost = new long[n - 1];
        long[] price = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n - 1; i++) {
            int c = Integer.parseInt(st.nextToken());
            cost[i] = c;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(cost, price, n));
    }
}
