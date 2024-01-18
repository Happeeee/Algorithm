import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            int a = str.charAt(0) - '0';
            int b = str.charAt(2) - '0';
            System.out.println("Case #" + (i + 1) + ": " + (a + b));
        }
    }
}
