import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] visited;

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = 1;
        q.add(start);

        while(!q.isEmpty()) {
            int from = q.poll();

            for(int i = 0; i < 3; i++) {
                int to = 0;
                if(i == 0) {
                    if(from % 3 == 0) {
                        to = from / 3;
                    }
                } else if(i == 1) {
                    if(from % 2 == 0) {
                        to = from / 2;
                    }
                } else if(i == 2) {
                    to = from - 1;
                }
                if(to < 1) {
                    continue;
                }

                if(visited[to] == 0) {
                    visited[to] = visited[from] + 1;
                }

                if(to == 1) {
                    return;
                }

                q.add(to);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new int[n + 1];
        bfs(n);
        System.out.println(visited[1] - 1);
    }
}
