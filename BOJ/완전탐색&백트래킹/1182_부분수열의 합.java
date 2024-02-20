import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int s;
    static int count = 0;
    static int[] arr;
    static boolean[] visited;

    public static void combi(int r, int start, int depth) {
        if(depth == r) {
            int sum = 0;
            for(int i = 0; i < n; i++) {
                if(visited[i]) {
                    sum += arr[i];
                }
            }
            if(sum == s) {
                count++;
            }
            return;
        }

        for(int i = start; i < n; i++) {
            visited[i] = true;
            combi(r, i + 1, depth + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            combi(i, 0, 0);
        }

        System.out.println(count);
    }
}

