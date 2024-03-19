import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    static int n;
    static ArrayList<Lecture> list = new ArrayList<>();
    static PriorityQueue<Lecture> pq = new PriorityQueue<>();

    static class Lecture implements Comparable<Lecture> {
        int m, d;

        Lecture(int m, int d) {
            this.m = m;
            this.d = d;
        }

        @Override
        public int compareTo(Lecture l) {
            return l.m - this.m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new Lecture(m, d));
            max = Math.max(max, d);
        }

        Collections.sort(list, new Comparator<Lecture>() {
            @Override
            public int compare(Lecture a, Lecture b) {
                return b.d - a.d;
            }
        });

        int answer = 0, j = 0;
        for(int i = max; i >= 1; i--) {
            while(j < n && list.get(j).d == i) {
                pq.add(list.get(j++));
            }
            if(!pq.isEmpty()) {
                answer += pq.poll().m;
            }
        }

        System.out.println(answer);
    }
}
