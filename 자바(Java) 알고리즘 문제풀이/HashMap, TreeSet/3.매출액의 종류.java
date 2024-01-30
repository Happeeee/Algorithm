import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        System.out.println(solution(n, k, s));
    }

    private static String solution(int n, int k, String s) {
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        sb.append(map.size()).append(" ");

        for(int i = k; i < n; i++) {
            int first = arr[i - k];
            if(map.get(first) == 1) {
                map.remove(first);
            } else {
                map.put(first, map.get(first) - 1);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            sb.append(map.size()).append(" ");
        }
        return sb.toString();
    }
}
