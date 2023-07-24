import java.util.*;

public class Main {
    private static boolean isContainVowel(String password) {
        for(char c : password.toCharArray()) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        }
        return false;
    }
    private static boolean isTriple(String password) {
        int count_con = 0; // 자음
        int count_vol = 0; // 모음

        for(char c : password.toCharArray()) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count_vol++;
                count_con = 0;
            }
            else {
                count_con++;
                count_vol = 0;
            }

            if(count_vol >= 3 || count_con >= 3) return true;
        }
        return false;
    }

    private static boolean isDouble(String password) {
        int count = 0;
        char prev = ' ';

        for(char c : password.toCharArray()) {
            if(prev == c)  {
                count++;
                prev = c;
            }
            else {
                count = 1;
                prev = c;
            }

            if(count == 2 && c != 'e' && c != 'o') return true;
        }
        return false;
    }
    private static boolean isGoodPassword(String password) {
        if(isContainVowel(password) && !isTriple(password) && !isDouble(password)) return true;
        else return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String password = sc.nextLine();
            if(password.equals("end")) break;

            if(isGoodPassword(password))
                System.out.println("<" + password + "> is acceptable." );
            else
                System.out.println("<" + password + "> is not acceptable." );
        }
    }
}
