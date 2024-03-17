import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static ArrayList<Meet> list = new ArrayList<>();

    static class Meet implements Comparable<Meet> {
        int start, end;

        Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meet m) {
            if(this.end == m.end) {
                return this.start - m.start;
            }
            return this.end - m.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Meet(s, e));
        }

        Collections.sort(list);

        int count = 0;
        int endTime = 0;

        for(Meet m : list) {
            if(m.start >= endTime) {
                count++;
                endTime = m.end;
            }
        }

        System.out.println(count);
    }
}
