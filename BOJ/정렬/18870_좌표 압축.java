import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> origin = new ArrayList<>();
        ArrayList<Integer> sorted = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            origin.add(num);
            sorted.add(num);
        }

        Collections.sort(sorted);

        int rank = 0;
        for(int i = 0; i < sorted.size(); i++) {
            int key = sorted.get(i);
            if(!map.containsKey(key)) {
                map.put(key, rank++);
            }
        }

        for(int i : origin) {
            sb.append(map.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
