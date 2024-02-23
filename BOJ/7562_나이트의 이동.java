import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] visited;
    static final int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
    static final int[] dy = {2, 2, 1, -1, -2, -2, -1, 1};

    static class Pos {
        int y;
        int x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void bfs(int sy, int sx, int ty, int tx) {
        Queue<Pos> q = new LinkedList<>();
        visited[sy][sx] = 1;
        q.add(new Pos(sy, sx));

        while(!q.isEmpty()) {
            Pos p = q.poll();

            for(int i = 0; i < 8; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if(visited[ny][nx] != 0) continue;

                visited[ny][nx] = visited[p.y][p.x] + 1;
                q.add(new Pos(ny, nx));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());
            visited = new int[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            bfs(sy, sx, ty, tx);
            System.out.println(visited[ty][tx] - 1);
        }
    }
}
