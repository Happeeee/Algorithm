import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = " ";
        while((s = br.readLine()) != null) {
            int l = 0;
            int u = 0;
            int num = 0;
            int space = 0;

            for(char c : s.toCharArray()) {
                if(Character.isLowerCase(c)) {
                    l++;
                } else if (Character.isUpperCase(c)) {
                    u++;
                } else if(Character.isDigit(c)) {
                    num++;
                } else if(Character.isSpaceChar(c)) {
                    space++;
                }
            }

            System.out.println(l + " " + u + " " + num + " " + space);
        }
    }
}
