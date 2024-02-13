import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][] visited;
    static int m;
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static Queue<Point> q = new LinkedList<>();

    static class Point {
        int y;
        int x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void bfs() {
        while(!q.isEmpty()) {
            Point p = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if(map[ny][nx] == -1 || visited[ny][nx] != 0) continue;

                visited[ny][nx] = visited[p.y][p.x] + 1;
                q.add(new Point(ny, nx));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];
        boolean flag = true;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if(num == 1) {
                    q.add(new Point(i, j));
                    visited[i][j] = 1;
                }

                if(num == 0) {
                    flag = false;
                }
            }
        }

        if(flag) {
            System.out.println(0);
            return;
        }

        bfs();

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == 0 && map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(visited[i][j], max);
            }
        }

        System.out.println(max - 1);
    }
}
