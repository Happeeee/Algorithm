import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(arr, n, m));
    }

    private static int solution(int[] arr, int n, int m) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    private static int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0;
        for(int i : arr) {
            if(sum + i <= capacity) {
                sum += i;
            } else {
                cnt++;
                sum = i;
            }
        }
        return cnt;
    }
}
