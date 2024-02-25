import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Pos> house = new ArrayList<>();
    static ArrayList<Pos> store = new ArrayList<>();
    static ArrayList<Pos> tmp = new ArrayList<>();

    static class Pos {
        int y;
        int x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static int distance(Pos p1, Pos p2) {
        return Math.abs(p1.y - p2.y) + Math.abs(p1.x - p2.x);
    }

    public static int chickenDistance(Pos h) {
        int cd = Integer.MAX_VALUE;
        for(Pos s : tmp) {
            cd = Math.min(cd, distance(h, s));
        }
        return cd;
    }

    public static void checkChickenDistance() {
        int ccd = 0;
        for(Pos h : house) {
            ccd += chickenDistance(h);
        }
        min = Math.min(min, ccd);
    }

    public static void combi(int depth, int start) {
        if(depth == m) {
            checkChickenDistance();
            return;
        }

        for(int i = start; i < store.size(); i++) {
            tmp.add(store.get(i));
            combi(depth + 1, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int p = Integer.parseInt(st.nextToken());
                if(p == 1) {
                    house.add(new Pos(i, j));
                } else if(p == 2) {
                    store.add(new Pos(i, j));
                }
            }
        }

        combi(0, 0);
        System.out.println(min);
    }
}
























