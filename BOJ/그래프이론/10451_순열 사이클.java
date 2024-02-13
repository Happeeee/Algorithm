import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] adj;
    static int[] visited;

    static void dfs(int from) {
        visited[from] = 1;

        for(int to : adj[from]) {
            if(visited[to] == 0) {
                dfs(to);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i < n + 1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            adj = new ArrayList[n + 1];
            visited = new int[n + 1];
            for(int i = 1; i < n + 1; i++) {
                adj[i] = new ArrayList<>();
            }

            for(int i = 1; i < n + 1; i++) {
                adj[i].add(arr[i]);
            }

            int count = 0;
            for(int i = 1; i < n + 1; i++) {
                if(visited[i] == 0) {
                    dfs(i);
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
