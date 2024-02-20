import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        int i = 666;
        while(true) {
            if(Integer.toString(i++).contains("666")) {
                count++;
                if(count == n) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
