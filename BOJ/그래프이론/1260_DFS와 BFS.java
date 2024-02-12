import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<Integer>[] adj;
    public static boolean[] visited;

    public static void dfs(int from) {
        visited[from] = true;
        System.out.print(from + " ");

        for(int to : adj[from]) {
            if(visited[to]) {
                continue;
            }
            dfs(to);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()) {
            int from = q.poll();
            System.out.print(from + " ");
            for(int to : adj[from]) {
                if(visited[to]) {
                    continue;
                }
                visited[to] = true;
                q.add(to);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        adj = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        for(int i = 1; i <= n; i++) {
            Collections.sort(adj[i]);
        }

        dfs(v);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(v);
    }
}
