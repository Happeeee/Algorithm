import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static final int[] dx = {-1, 1, 2};
    static int[] visited = new int[200004];
    static int[] count = new int[200004];

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        visited[n] = 1;
        count[n] = 1;
        q.add(n);

        while(!q.isEmpty()) {
            int x = q.poll();

            for(int i = 0; i < 3; i++) {
                int nx = x;
                if(i == 0) nx += dx[0];
                else if(i == 1) nx += dx[1];
                else if(i == 2) nx *= dx[2];

                if(nx < 0 || nx > 200000) continue;
                if(visited[nx] == 0) {
                    // 일단 방문된 적이 없는 곳만 가야하고
                    visited[nx] = visited[x] + 1;
                    count[nx] += count[x];
                    q.add(nx);
                } else {
                    // 방문된 적이 있더라도 같은 레벨이면 카운팅
                    if(visited[nx] == visited[x] + 1) {
                        count[nx] += count[x];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n == k) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        bfs();
        System.out.println(visited[k] - 1);
        System.out.println(count[k]);
    }
}























