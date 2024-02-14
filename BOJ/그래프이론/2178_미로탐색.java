import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][] visited;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    static int n;
    static int m;

    static class Point {
        int y;
        int x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1));
        visited[1][1] = 1;

        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx < 1 || ny < 1 || nx > m || ny > n) continue;
                if(map[ny][nx] == 0 || visited[ny][nx] != 0) continue;

                visited[ny][nx] = visited[p.y][p.x] + 1;
                q.add(new Point(ny, nx));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        visited = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            String s = br.readLine();
            for(int j = 1; j <= m; j++) {
                map[i][j] = s.charAt(j - 1) - '0';
            }
        }

        bfs();

        System.out.println(visited[n][m]);
    }
}
