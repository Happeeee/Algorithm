import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                if(s.charAt(j) == 'W') {
                    map[i][j] = true;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= n - 8; i++) {
            for(int j = 0; j <= m - 8; j++) {

                int count = 0;
                boolean first = map[i][j];

                for(int r = i; r < i + 8; r++) {
                    for(int c = j; c < j + 8; c++) {
                        if(map[r][c] != first) {
                            count++;
                        }
                        first = !first;
                    }
                    first = !first;
                }
                count = Math.min(count, 64 - count);
                min = Math.min(min, count);
            }
        }

        System.out.println(min);
    }
}


