import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] visited = new int[100001];

    public static void bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        visited[n] = 1;
        q.add(n);

        while(!q.isEmpty()) {
            int here = q.poll();

            for(int i = 0; i < 3; i++) {
                int next = here;
                if(i == 0) next = here - 1;
                if(i == 1) next = here + 1;
                if(i == 2) next = here * 2;

                if(next == k) {
                    visited[next] = visited[here] + 1;
                    return;
                }

                if(next < 0 || next > 100000) continue;
                if(visited[next] != 0) continue;

                visited[next] = visited[here] + 1;
                q.add(next);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n == k) {
            System.out.println(0);
        } else {
            bfs(n, k);
            System.out.println(visited[k] - 1);
        }
    }
}
