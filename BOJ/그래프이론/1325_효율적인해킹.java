import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    private static List<Integer>[] adj;
    private static int[] arr;
    private static boolean[] visited;
    private static int n, m, max = -1;

    private static void bfs(int u) {
        Queue<Integer> q = new LinkedList<>();
        visited[u] = true;
        q.add(u);

        while(!q.isEmpty()) {
            int here = q.poll();

            for(int there : adj[here]) {
                if(!visited[there]) {
                    visited[there] = true;
                    arr[there]++;
                    q.add(there);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        adj = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();


        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
        }

        for(int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }

        for(int i = 1; i <= n; i++)
            if(max < arr[i])
                max = arr[i];
        
        for(int i = 1; i <= n; i++) {
            if(arr[i] == max)
                System.out.print(i + " ");
        }
    }
}
