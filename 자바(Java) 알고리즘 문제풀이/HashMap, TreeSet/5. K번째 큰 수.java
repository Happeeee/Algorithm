import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, k, arr));
    }

    private static int solution(int n, int k, int[] arr) {
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for(int a = 0; a < n; a++) {
            for(int b = a + 1; b < n; b++) {
                for(int c = b + 1; c < n; c++) {
                    set.add(arr[a] + arr[b] + arr[c]);
                }
            }
        }
        for(int sum : set) {
            if(k == 1) {
                return sum;
            }
            k--;
        }
        return -1;
    }

}
