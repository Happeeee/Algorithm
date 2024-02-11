import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        ArrayList<Integer> list = new ArrayList<>();
        for(char c : s.toCharArray()) {
            list.add(c - '0');
        }
        Collections.sort(list, Comparator.reverseOrder());
        for(int i : list) {
            sb.append(i);
        }
        System.out.println(sb);
    }
}
