import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n, count, max = Integer.MIN_VALUE;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Pos> q = new LinkedList<>();

    static class Pos {
        int y;
        int x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            Pos p = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if(map[ny][nx] == -1 || visited[ny][nx] != 0) continue;

                visited[ny][nx] = visited[p.y][p.x] + 1;
                q.add(new Pos(ny, nx));
                count--;
                max = Math.max(max, visited[ny][nx]);
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

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    q.add(new Pos(i, j));
                    visited[i][j] = 1;
                } else if(map[i][j] == 0) {
                    count++;
                }
            }
        }

        bfs();

        if(count == 0) {
            System.out.println(max - 1);
        } else {
            System.out.println(-1);
        }
    }
}
