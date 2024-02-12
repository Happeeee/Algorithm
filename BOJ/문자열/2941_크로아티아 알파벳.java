import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] str = s.toCharArray();
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = str[i];

            if(c == 'c' && i < s.length() - 1) {
                if(str[i + 1] == '=' || str[i + 1] == '-') {
                    i++;
                }
            }

            if(c == 'd') {
                if(i < s.length() - 1 && str[i + 1] == '-') {
                    i++;
                } else if(i < s.length() - 2 && str[i + 1] == 'z' && str[i + 2] == '=') {
                    i += 2;
                }
            }

            if((c == 'l' || c == 'n') && i < s.length() - 1) {
                if(str[i + 1] == 'j') {
                    i++;
                }
            }

            if((c == 's' || c == 'z') && i < s.length() - 1) {
                if(str[i + 1] == '=') {
                    i++;
                }
            }

            count++;
        }

        System.out.println(count);
    }
}
