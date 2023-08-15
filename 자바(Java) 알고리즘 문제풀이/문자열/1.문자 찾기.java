import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        char c = sc.nextLine().charAt(0);

        int count = 0;
        for(char a : str.toCharArray()) {
            if(Character.toLowerCase(a) == Character.toLowerCase(c)) count++;
        }
        System.out.println(count);
    }
}
