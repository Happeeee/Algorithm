import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
             st = new StringTokenizer(br.readLine());
             int r = Integer.parseInt(st.nextToken());
             String s = st.nextToken();

             for(char c : s.toCharArray()) {
                 for(int j = 0; j < r; j++) {
                     sb.append(c);
                 }
             }
             sb.append("\n");
        }
        System.out.println(sb);
    }
}
