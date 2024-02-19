import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int a = 0;
        int b = 0;
        int c = 0;
        int year = 0;

        while(true) {
            a++; if(a > 15) a = 1;
            b++; if(b > 28) b = 1;
            c++; if(c > 19) c = 1;
            year++;

            if(a == e && b == s && c == m) {
                System.out.println(year);
                return;
            }
        }
    }
}
