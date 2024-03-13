import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map = new int[8][8];
    static int[][] visited = new int[8][8];
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Pos {
        int y;
        int x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void bfs(int y, int x) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(y, x));
        visited[y][x] = 1;

        while(!q.isEmpty()) {
            Pos p = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(ny < 1 || nx < 1 || ny > 7 || nx > 7) continue;
                if(map[ny][nx] == 1 || visited[ny][nx] != 0) continue;

                q.add(new Pos(ny, nx));
                visited[ny][nx] = visited[p.y][p.x] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 1; i < 8; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j < 8; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(1, 1);

        if(visited[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(visited[7][7] - 1);
        }
    }
}
