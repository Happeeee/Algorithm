import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int r;
    static int count = 1;

    static ArrayList<Integer>[] adj;
    static int[] visited;

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = count;
        q.add(start);

        while(!q.isEmpty()) {
            int from = q.poll();

            for(int to : adj[from]) {
                if(visited[to] == 0) {
                    visited[to] = ++count;
                    q.add(to);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        visited = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        for(int i = 1; i <= n; i++) {
            Collections.sort(adj[i], Comparator.reverseOrder());
        }

        bfs(r);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }
}
