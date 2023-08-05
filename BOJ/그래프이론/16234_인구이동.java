import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {

    private static int[][] map = new int[50][50];
    private static int[][] visited = new int[50][50];
    private static int[] unionSum = new int[2504];
    private static int[] unionCount = new int[2504];
    private static int n, l, r;
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

    private static void dfs(int y, int x, int a) {
        visited[y][x] = a;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
            int distance = Math.abs(map[y][x] - map[ny][nx]);
            if(distance < l || distance > r) continue;
            if(visited[ny][nx] != 0) continue;
            dfs(ny, nx, a);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int day = 0;
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            for(int i = 0; i < n; i++)
                Arrays.fill(visited[i], 0);

            // 문 열고 연합 생성
            int a = 1;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(visited[i][j] == 0) {
                        dfs(i, j, a++);
                    }
                }
            }

            // 모든 나라의 국경선이 닫혀있다면 종료
            if(a - 1 == n * n) break; 

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    int union = visited[i][j];
                    unionSum[union] += map[i][j];
                    unionCount[union]++;
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    int union = visited[i][j];
                    map[i][j] = unionSum[union] / unionCount[union];
                }
            }

            Arrays.fill(unionSum, 0);
            Arrays.fill(unionCount, 0);

            day++;
        }
        System.out.println(day);
    }
}
