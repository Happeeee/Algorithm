import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Point[] arr = new Point[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Point(x, y);
        }
        Arrays.sort(arr, comp);
        for(Point p : arr) {
            System.out.println(p.x + " " + p.y);
        }
    }

    private static Comparator<Point> comp = new Comparator<Point>() {
        @Override
        public int compare(Point a, Point b) {
            if(a.x == b.x) {
                return a.y - b.y;
            }
            return a.x - b.x;
        }
    };
}
