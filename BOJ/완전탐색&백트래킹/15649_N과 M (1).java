import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static int n;
    static int m;

    public static void permutation(int depth) {
        if(depth == m) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n + 1];

        permutation(0);
    }
}
