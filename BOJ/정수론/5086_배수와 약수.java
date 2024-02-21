import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static String solve(int n1, int n2) {
        if(n2 % n1 == 0) {
            return "factor";
        }
        if(n1 % n2 == 0) {
            return "multiple";
        }
        return "neither";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while(!(s = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(s);
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            System.out.println(solve(n1, n2));
        }
    }
}
