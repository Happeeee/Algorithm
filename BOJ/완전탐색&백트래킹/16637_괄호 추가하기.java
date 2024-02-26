import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int max = Integer.MIN_VALUE;
    static ArrayList<Integer> numList = new ArrayList<>();
    static ArrayList<Character> operList = new ArrayList<>();

    public static int oper(char op, int a, int b) {
        if(op == '+') return a + b;
        if(op == '-') return a - b;
        if(op == '*') return a * b;
        return 0;
    }

    public static void go(int depth, int num) {
        if(depth == numList.size() - 1) {
            max = Math.max(max, num);
            return;
        }

        go(depth + 1, oper(operList.get(depth), num, numList.get(depth + 1)));
        if(depth + 2 <= numList.size() - 1) {
            int temp = oper(operList.get(depth + 1), numList.get(depth + 1), numList.get(depth + 2));
            go(depth + 2, oper(operList.get(depth), num, temp));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(i % 2 == 0) {
                numList.add(c - '0');
            } else {
                operList.add(c);
            }
        }

        go(0, numList.get(0));
        System.out.println(max);
    }
}























