import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int k;
    static char[] arr = new char[10];
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<String> result = new ArrayList<>();
    static boolean[] visited = new boolean[10];

    public static boolean canGo(char c, int a, int b) {
        if(c == '<') return a < b;
        else return a > b;
    }

    public static void go(int depth) {
        if(depth == k + 1) {
            StringBuilder sb = new StringBuilder();
            for(int i : list) {
                sb.append(i);
            }
            result.add(sb.toString());
            return;
        }

        for(int i = 0; i <= 9; i++) {
            if(!visited[i]) {
                if(!list.isEmpty() && !canGo(arr[list.size() - 1], list.get(list.size() - 1), i)) continue;
                visited[i] = true;
                list.add(i);
                go(depth + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        String s = br.readLine();
        for(int i = 0; i < k; i++) {
            arr[i] = s.charAt(i * 2);
        }

        go(0);
        Collections.sort(result);
        System.out.println(result.get(result.size() - 1));
        System.out.println(result.get(0));
    }
}
