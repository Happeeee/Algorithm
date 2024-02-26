import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static int[] visited = new int[200004];
    static int[] prev = new int[200004];

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        visited[n] = 1;
        q.add(n);

        while(!q.isEmpty()) {
            int x = q.poll();

            int[] temp = {x - 1, x + 1, x * 2};
            for(int nx : temp) {
                if(nx < 0 || nx > 200000) continue;
                if(visited[nx] != 0) continue;
                visited[nx] = visited[x] + 1;
                prev[nx] = x;
                q.add(nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = k; i != n; i = prev[i]) {
            list.add(i);
        }
        list.add(n);
        Collections.reverse(list);

        System.out.println(visited[k] - 1);
        for(int i : list) {
            System.out.print(i + " ");
        }
    }
}
