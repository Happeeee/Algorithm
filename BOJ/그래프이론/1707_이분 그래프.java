import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<Integer>[] adj;
    public static int[] visited;

    public static void dfs(int from, int color) {
        visited[from] = color;

        for(int to : adj[from]) {
            if(visited[to] == -1) {
                dfs(to, (color + 1) % 2);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj = new ArrayList[v + 1];
            visited = new int[v + 1];
            for(int j = 0; j <= v; j++) {
                adj[j] = new ArrayList<>();
            }
            Arrays.fill(visited, -1);

            for(int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                adj[v1].add(v2);
                adj[v2].add(v1);
            }

            for(int j = 1; j <= v; j++) {
                if(visited[j] == -1) {
                    dfs(j, 0);
                }
            }

            String answer = "YES";
            for(int from = 1; from <= v; from++) {
                for(int to : adj[from]) {
                    if(visited[from] == visited[to]) {
                        answer = "NO";
                        break;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
