import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visited;

    public static void combi(int n, int r, int start, int depth) {
        if(depth == r) {
            for(int i = 0; i < n; i++) {
                if(visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for(int i = start; i < n; i++) {
            visited[i] = true;
            combi(n, r, i + 1,depth + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while(!(s = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(s);
            int k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            visited = new boolean[k];
            for(int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            combi(k, 6, 0, 0);
            System.out.println();
        }
    }
}
