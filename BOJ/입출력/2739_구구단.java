import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 9; i++) {
            sb.append(n).append(" * ").append(i).append(" = ").append(i * n).append("\n");
        }
        System.out.println(sb);
    }
}
