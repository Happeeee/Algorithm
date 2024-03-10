import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, max = Integer.MIN_VALUE;
    static int[] score;
    static int[] time;

    public static void dfs(int depth, int totalTime, int totalScore) {
        if(totalTime > m) return;
        if(depth == n) {
            max = Math.max(max, totalScore);
            return;
        }

        dfs(depth + 1, totalTime + time[depth], totalScore + score[depth]);
        dfs(depth + 1, totalTime, totalScore);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        score = new int[n];
        time = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(max);
    }
}
