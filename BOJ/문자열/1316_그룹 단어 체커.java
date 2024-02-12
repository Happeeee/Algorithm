import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            if(isGroupWord(s)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isGroupWord(String s) {
        boolean[] arr = new boolean[26];
        Arrays.fill(arr, false);
        char prev = s.charAt(0);

        for(char c : s.toCharArray()) {
            if(prev != c) {
                if(arr[c - 'a']) {
                    return false;
                }
            }
            arr[c - 'a'] = true;
            prev = c;
        }
        return true;
    }
}
