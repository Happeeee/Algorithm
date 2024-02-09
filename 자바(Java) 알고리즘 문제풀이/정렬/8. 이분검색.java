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
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(solution(arr, n, m));
    }

    private static int solution(int[] arr, int n, int key) {
        int lt = 0, rt = n - 1;
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(arr[mid] == key) {
                return mid + 1;
            }
            if(arr[mid] > key) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return -1;
    }
}
