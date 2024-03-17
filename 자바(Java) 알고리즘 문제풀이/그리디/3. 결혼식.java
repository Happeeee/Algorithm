import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static ArrayList<Person> list = new ArrayList<>();

    static class Person implements Comparable<Person> {
        int time;
        char state;

        Person(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Person p) {
            if(this.time == p.time) return this.state - p.state;
            return this.time - p.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Person(s, 's'));
            list.add(new Person(e, 'e'));
        }

        Collections.sort(list);

        int count = 0, answer = 0;
        for(Person p : list) {
            if(p.state == 's') count++;
            else count--;

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
