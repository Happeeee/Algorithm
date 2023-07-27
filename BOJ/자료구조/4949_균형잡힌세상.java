import java.util.*;
public class Main {    

    private static boolean isBalanced(String str) {
        Stack<Character> s = new Stack<>();

        for(char c : str.toCharArray()) {
            if(c == '(' || c == '[')
                s.push(c);

            if(c == ')') {
                if(s.isEmpty()) return false;
                if(s.pop() != '(') return false;
            }

            if(c == ']') {
                if(s.isEmpty()) return false;
                if(s.pop() != '[') return false;
            }
        }

        if(s.isEmpty()) return true;
        else return false;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String s = sc.nextLine();
            if(s.equals(".")) break;

            if(isBalanced(s)) System.out.println("yes");
            else System.out.println("no");
        }

    }
}
