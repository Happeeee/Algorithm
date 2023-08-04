import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  
    private static int n, m, max = -1;
    private static char[][] map;
    private static int[][] visited;
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    private static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static void bfs(int y, int x) {
        for(int i = 0; i < n; i++)
            Arrays.fill(visited[i], 0);

        Queue<Point> q = new LinkedList<>();
        visited[y][x] = 1;
        q.add(new Point(y, x));

        while(!q.isEmpty()) {
            Point point = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = point.y + dy[i];
                int nx = point.x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(map[ny][nx] == 'W' || visited[ny][nx] != 0) continue;
                visited[ny][nx] = visited[point.y][point.x] + 1;
                max = Math.max(max, visited[ny][nx]);
                q.add(new Point(ny, nx));
            }
        }
    }
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(max - 1);

    }
}
