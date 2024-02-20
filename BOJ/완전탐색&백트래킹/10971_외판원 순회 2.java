import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int min = Integer.MAX_VALUE;
    static int[][] cost;
    static boolean[] visited;

    public static void dfs(int start, int from, int sum, int depth) {
        if(depth == n - 1) {
            if(cost[from][start] > 0) {
                sum += cost[from][start];
                min = Math.min(min, sum);
            }
            return;
        }
        visited[from] = true;

        for(int to = 0; to < n ; to++) {
            if(!visited[to] && cost[from][to] > 0) {
                visited[to] = true;
                dfs(start, to, sum + cost[from][to], depth + 1);
                visited[to] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int c = Integer.parseInt(st.nextToken());
                cost[i][j] = c;
            }
        }

        for(int i = 0; i < n; i++) {
            dfs(i, i, 0, 0);
        }
        System.out.println(min);
    }
}
