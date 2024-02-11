import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, comp);

        for(String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    public static Comparator<String> comp = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            if(s1.length() == s2.length()) {
                return s1.compareTo(s2);
            } else {
                return s1.length() - s2.length();
            }
        }
    };
}
