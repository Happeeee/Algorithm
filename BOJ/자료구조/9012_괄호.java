import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++) {
            String str = sc.nextLine();

            Stack<Character> s = new Stack<>();
            boolean isVps = true;

            for(char c : str.toCharArray()) {
                if(c == ')') {
                    if(s.isEmpty()) {
                        isVps = false;
                        break;
                    }
                    else s.pop();
                } else
                    s.push(c);
            }

            if(s.isEmpty() && isVps) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

