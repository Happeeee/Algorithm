import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static int count;
    static char[][] map = new char[22][22];
    static boolean[] a = new boolean[26];
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    public static void dfs(int y, int x, int sum) {
        count = Math.max(count, sum);
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= r || nx >= c || a[map[ny][nx] - 'A']) continue;

            a[map[ny][nx] - 'A'] = true;
            dfs(ny, nx, sum + 1);
            a[map[ny][nx] - 'A'] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for(int i = 0; i < r; i++) {
            String s = br.readLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        a[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(count);
    }
}
