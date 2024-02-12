import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[26];
        String s = br.readLine();

        for(char c : s.toCharArray()) {
            if(Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
            }
            count[c - 'a']++;
        }

        int max = -1;
        char answer = ' ';

        for(int i = 0; i < 26; i++) {
            if(count[i] > max) {
                 max = count[i];
                 answer = (char)('A'+ i);
            } else if(count[i] == max) {
                answer = '?';
                break;
            }
        }

        System.out.println(answer);
    }
}
