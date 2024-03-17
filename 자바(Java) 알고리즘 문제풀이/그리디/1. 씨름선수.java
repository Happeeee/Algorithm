import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static ArrayList<Person> list = new ArrayList<>();

    static class Person {
        int height;
        int weight;

        Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Person(h, w));
        }

        Collections.sort(list, comp);

        int count = 1;
        int maxWeight = list.get(0).weight;

        for(Person p : list) {
            if(p.weight > maxWeight) count++;
            maxWeight = Math.max(maxWeight, p.weight);
        }

        System.out.println(count);
    }

    public static Comparator<Person> comp = new Comparator<Person>() {
        @Override
        public int compare(Person a, Person b) {
            return b.height - a.height;
        }
    };
}
