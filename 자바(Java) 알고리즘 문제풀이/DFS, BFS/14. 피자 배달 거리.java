import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n, m, answer = Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<Pos> pizza = new ArrayList<>();
    static ArrayList<Pos> house = new ArrayList<>();
    static ArrayList<Pos> temp = new ArrayList<>();

    static class Pos {
        int y;
        int x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static int distance(Pos p1, Pos p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public static void combi(int start, int depth) {
        if(depth == m) {
            int sum = 0;
            for(Pos h : house) {
                int min = Integer.MAX_VALUE;
                for(Pos p : temp) {
                    min = Math.min(min, distance(h, p));
                }
                sum += min;
            }
            answer = Math.min(answer, sum);
            return;
        }

        for(int i = start; i < pizza.size(); i++) {
            temp.add(pizza.get(i));
            combi(i + 1, depth + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    pizza.add(new Pos(i, j));
                } else if(map[i][j] == 1) {
                    house.add(new Pos(i, j));
                }
            }
        }

        combi(0, 0);
        System.out.println(answer);
    }
}
