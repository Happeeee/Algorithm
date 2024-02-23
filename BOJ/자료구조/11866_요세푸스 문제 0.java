import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(list.size() > 1) {
            index = (index + k - 1) % list.size();
            sb.append(list.remove(index)).append(", ");
        }
        sb.append(list.remove(0)).append(">");

        System.out.println(sb);
    }
}
