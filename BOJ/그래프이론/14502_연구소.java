import java.util.*;
public class Main {
    private static int n, m;
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1 ,0 ,0};
    private static int[][] map = new int[10][10];
    private static boolean[][] visited = new boolean[10][10];
    private static List<Pos> virusList = new ArrayList<>();
    private static List<Pos> emptyList = new ArrayList<>();
  
    private static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if(map[ny][nx] == 0 && !visited[ny][nx])
                dfs(ny, nx);
        }
    }
  
    private static int getArea() {
        // dfs로 2퍼트리기 -> 0 개수 구하기        
        for(int i = 0; i < visited.length; i++)
            Arrays.fill(visited[i], false);

        for(Pos pos : virusList)
            dfs(pos.y, pos.x);

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0 && !visited[i][j])
                    count++;
            }
        }
        return count;
    }
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = -1;

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int num = sc.nextInt();
                map[i][j] = num;
                if(num == 2) virusList.add(new Pos(i, j));
                else if(num == 0) emptyList.add(new Pos(i, j));
            }
        }

        int length = emptyList.size();
        for(int i = 0; i < length; i++) {
            for(int j = i + 1; j < length; j++) {
                for(int k = j + 1; k < length; k++) { // 0의 좌표들 중 3개를 고르는 조합
                    map[emptyList.get(i).y][emptyList.get(i).x] = 1;
                    map[emptyList.get(j).y][emptyList.get(j).x] = 1;
                    map[emptyList.get(k).y][emptyList.get(k).x] = 1;
                    result = Math.max(getArea(), result);
                    map[emptyList.get(i).y][emptyList.get(i).x] = 0;
                    map[emptyList.get(j).y][emptyList.get(j).x] = 0;
                    map[emptyList.get(k).y][emptyList.get(k).x] = 0;
                }
            }
        }

        System.out.println(result);

    }


}
