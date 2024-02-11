import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x, y));
        }

        Collections.sort(list, comp);

        for(Point p : list) {
            System.out.println(p.x + " " + p.y);
        }
    }

    public static Comparator<Point> comp = new Comparator<Point>() {
        @Override
        public int compare(Point p1, Point p2) {
            if(p1.x == p2.x) {
                return p1.y - p2.y;
            } else {
                return p1.x - p2.x;
            }
        }
    };
}
