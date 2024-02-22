import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int e;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public static void dfs(int from) {
        visited[from] = true;

        for(int to : adj[from]) {
            if(!visited[to]) {
                dfs(to);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];

        for(int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(1);

        int count = 0;
        for(int i = 2; i <= n; i++) {
            if(visited[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
