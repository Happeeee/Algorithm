import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int count = 0;
    static int[][] map = new int[8][8];
    static boolean[][] visited = new boolean[8][8];
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void dfs(int y, int x) {
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 1 || nx < 1 || ny > 7 || nx > 7) continue;
            if(map[ny][nx] == 1 || visited[ny][nx]) continue;
            if(ny == 7 && nx == 7) {
                count++;
                continue;
            }

            visited[ny][nx] = true;
            dfs(ny, nx);
            visited[ny][nx] = false;
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

        visited[1][1] = true;
        dfs(1, 1);
        System.out.println(count);
    }
}
