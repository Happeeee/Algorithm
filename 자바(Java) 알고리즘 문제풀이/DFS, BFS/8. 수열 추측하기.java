import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, f;
    static boolean flag = false;
    static int[] arr;
    static int[][] temp;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {
        if(flag) return;

        if(depth == n) {
            for(int i = 0; i < n; i++) {
                temp[0][i] = arr[i];
            }

            for(int i = 1; i < n; i++) {
                for(int j = 0; j < n - i; j++) {
                    temp[i][j] = temp[i - 1][j] + temp[i - 1][j + 1];
                }
            }

            if(temp[n - 1][0] == f) {
                flag = true;
                for(int i : arr) {
                    sb.append(i).append(" ");
                }
                return;
            }

            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        arr = new int[n];
        temp = new int[n][n];
        visited = new boolean[n + 1];

        dfs(0);
        System.out.println(sb);
    }
}
