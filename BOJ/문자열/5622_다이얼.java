import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = 0;
        for(char c : s.toCharArray()) {
            sum += getSecond(c);
        }
        System.out.println(sum);
    }

    public static int getSecond(char a) {
        if(a >= 'A' && a <= 'C') {
            return 3;
        } else if(a >= 'D' && a <= 'F') {
            return 4;
        } else if(a >= 'G' && a <= 'I') {
            return 5;
        } else if(a >= 'J' && a <= 'L') {
            return 6;
        } else if(a >= 'M' && a <= 'O') {
            return 7;
        } else if(a >= 'P' && a <= 'S') {
            return 8;
        } else if(a >= 'T' && a <= 'V') {
            return 9;
        } else if(a >= 'W' && a <= 'Z') {
            return 10;
        }
        return -1;
    }
}
