import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] jobs = new int[n];
        for(int i = 0; i < n; i++) {
            jobs[i] = Integer.parseInt(st.nextToken());
        }
        for(int i : solution(jobs, s)) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(int[] jobs, int cacheSize) {
        int[] cache = new int[cacheSize];
        for(int job : jobs) {
            int pos = -1;
            for(int i = 0; i < cacheSize; i++) {
                if(cache[i] == job) {
                    pos = i;
                }
            }
            if(pos == -1) {
                for(int i = cacheSize - 1; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for(int i = pos; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = job;
        }
        return cache;
    }
}
