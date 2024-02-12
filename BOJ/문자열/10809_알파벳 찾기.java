import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] result = new int[26];
        Arrays.fill(result, -1);
        char[] arr = br.readLine().toCharArray();

        for(int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if(result[c - 'a'] == -1) {
                result[c - 'a'] = i;
            }
        }

        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
