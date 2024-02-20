import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int f, s, g, u, d;
    static int[] visited;

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        visited[s] = 1;
        q.add(s);

        while(!q.isEmpty()) {
            int here = q.poll();

            for(int i = 0; i < 2; i++) {
                int next = here;
                if(i == 0) next = here + u;
                if(i == 1) next = here - d;

                if(next == g) {
                    visited[next] = visited[here] + 1;
                    return;
                }

                if(next < 1 || next > f) continue;
                if(visited[next] != 0) continue;

                visited[next] = visited[here] + 1;
                q.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken()); // 가장 높은 층
        s = Integer.parseInt(st.nextToken()); // 강호의 위치
        g = Integer.parseInt(st.nextToken()); // 목적지
        u = Integer.parseInt(st.nextToken()); // 위로 u층
        d = Integer.parseInt(st.nextToken()); // 아래로 d층

        visited = new int[f + 1];

        bfs();

        if(visited[g] != 0) {
            System.out.println(visited[g] - 1);
        } else {
            System.out.println("use the stairs");
        }
    }
}
