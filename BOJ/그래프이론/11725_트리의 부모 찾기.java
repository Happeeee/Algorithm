import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] parent;

    public static void dfs(int from) {
        visited[from] = true;

        for(int to : adj[from]) {
            if(!visited[to]) {
                parent[to] = from;
                dfs(to);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
        parent = new int[n + 1];

        for(int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            adj[n1].add(n2);
            adj[n2].add(n1);
        }

        dfs(1);

        for(int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}
