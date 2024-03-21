import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> set = new HashSet<>();
        int count = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for(int i = 0; i < m; i++) {
            if(set.contains(br.readLine())) count++;
        }

        System.out.println(count);
    }
}
