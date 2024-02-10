import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int n = 10001;
    static final int[] dx = {1, -1, 5};
    static final int[] visited = new int[n];

    static int s;
    static int e;

    private static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = 1;

        while(!q.isEmpty()) {
            int here = q.poll();

            for(int i = 0; i < 3; i++) {
                int nx = here + dx[i];

                if(nx >= 10000 || nx < 0) continue;
                if(visited[nx] != 0) continue;

                q.add(nx);
                visited[nx] = visited[here] + 1;

                if(nx == e) {
                    return visited[nx] - visited[s];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        System.out.println(bfs());
    }
}
