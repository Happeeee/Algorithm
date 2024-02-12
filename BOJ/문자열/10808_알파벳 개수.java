import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26];

        for(char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
