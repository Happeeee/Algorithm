import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int next(int n, int p) {
        int sum = 0;
        while(n > 0) {
            sum += (int)Math.pow(n % 10, p);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        list.add(a);

        while(true) {
            int next = next(a, p);
            if(list.contains(next)) {
                System.out.println(list.indexOf(next));
                return;
            }
            list.add(next);
            a = next;
        }
    }
}
