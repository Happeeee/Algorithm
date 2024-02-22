import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int n;
    static int[][] map;
    static int[][] visited;
    static Map<Integer, Integer> m = new HashMap<>();

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    public static void dfs(int y, int x, int group) {
        visited[y][x] = group;
        m.put(group, m.getOrDefault(group, 0) + 1);

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if(map[ny][nx] == 0 || visited[ny][nx] != 0) continue;

            dfs(ny, nx, group);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new int[n][n];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int group = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1 && visited[i][j] == 0) {
                    dfs(i, j, ++group);
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= group; i++) {
            list.add(m.get(i));
        }
        Collections.sort(list);

        System.out.println(group);
        for(int i : list) {
            System.out.println(i);
        }
    }
}
