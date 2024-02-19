import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int max = Integer.MIN_VALUE;
    static int[] base;
    static int[] swap;
    static boolean[] visited;

    public static int exp() {
        int sum = 0;
        for(int i = 2; i <= n; i++) {
            sum += Math.abs(swap[i - 2] - swap[i - 1]);
        }
        return sum;
    }

    public static void permutation(int depth) {
        if(depth == n) {
            max = Math.max(max, exp());
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                swap[depth] = base[i];
                permutation(depth + 1 );
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        base = new int[n];
        swap = new int[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            base[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0);
        System.out.println(max);
    }
}
