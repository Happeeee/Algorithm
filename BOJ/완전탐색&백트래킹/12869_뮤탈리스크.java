import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr = new int[3];
    static int[][][] visited = new int[64][64][64];
    static final int[][] attack = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 9, 3},
            {1, 3, 9}
    };

    static class Node {
        int a, b, c;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void bfs(int a, int b, int c) {
        Queue<Node> q = new LinkedList<>();
        visited[a][b][c] = 1;
        q.add(new Node(a, b, c));

        while(!q.isEmpty()) {
            Node n = q.poll();

            for(int i = 0; i < 6; i++) {
                int na = Math.max(0, n.a - attack[i][0]);
                int nb = Math.max(0, n.b - attack[i][1]);
                int nc = Math.max(0, n.c - attack[i][2]);

                if(visited[na][nb][nc] != 0) continue;

                visited[na][nb][nc] = visited[n.a][n.b][n.c] + 1;
                q.add(new Node(na, nb, nc));

                if(visited[0][0][0] != 0) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)  {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bfs(arr[0], arr[1], arr[2]);
        System.out.println(visited[0][0][0] - 1);
    }
}
