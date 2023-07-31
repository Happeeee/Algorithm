import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        int[] arr = new int[1000004];
        int[] nges = new int[1000004];

        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            while(s.size() > 0 && arr[s.peek()] < arr[i])
                nges[s.pop()] = arr[i];
            s.push(i);
        }

        for(int i = 1; i <= n; i++) {
            if(nges[i] == 0) sb.append(-1);
            else sb.append(nges[i]);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}
