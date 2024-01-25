import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int space = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= n - i; j++) {
                sb.append(" ");
            }
            sb.append("*");
            if(i != 1) {
                for(int j = 1; j <= space; j++) {
                    sb.append(" ");
                }
                space += 2;
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i = 1; i <= 2 * n - 1; i++) {
            sb.append("*");
        }
        System.out.println(sb);
    }
}
