import java.util.*;
public class Main {    
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    private static int n, m; // n : 가로, m : 세로
    private static int[][] map = new int[100][100];
    private static boolean[][] air = new boolean[100][100];
    private static List<Pos> cList = new ArrayList<>();

    private static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static void dfs(int y, int x) {
        air[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if(map[ny][nx] == 1 || air[ny][nx]) continue;
            dfs(ny, nx);
        }
    }

    private static void assignC() {
        for(int y = 1; y < n - 1; y++) {
            for(int x = 1; x < m - 1; x++) {

                if(map[y][x] == 1) {
                    for(int i = 0; i < 4; i++) {
                        int ny = y + dy[i];
                        int nx = x + dx[i];

                        if(air[ny][nx]) {
                            map[y][x] = 2; // int 배열이므로 c를 2로 대체
                            cList.add(new Pos(y, x));
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void meltC() {
        for(Pos pos : cList) 
            map[pos.y][pos.x] = 0;

        cList.clear();
    }
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cCount = 0;
        int time = 0;

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        while(true) {
            time++;
            // 공기 주입(가장자리 dfs 돌리는 로직)
            for (int i = 0; i < n; i++) {
                dfs(i, 0);
                dfs(i, m - 1);
            }

            for (int i = 1; i < m - 1; i++) {
                dfs(0, i);
                dfs(n - 1, i);
            }

            assignC(); // c 배정
            cCount = cList.size(); // c 개수 담아놓기
            meltC(); // c 녹이기

            for(int i = 0; i < n; i++)
                Arrays.fill(air[i], false);

            // 모든 치즈가 없어졌다면 break 하고 time, cCount 출력
            int count1 = 0;
            for(int i = 0; i < n; i++)
                for(int j = 0; j < m; j++)
                    if(map[i][j] == 1) count1++;
            if(count1 == 0) break;
        }

        System.out.println(time);
        System.out.println(cCount);
    }
}
