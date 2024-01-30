import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        System.out.println(solution(s));
    }

    private static Character solution(String s) {
        int maxCount = 0;
        char leader = ' ';

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : map.keySet()) {
            if(map.get(c) > maxCount) {
                maxCount = map.get(c);
                leader = c;
            }
        }
        return leader;
    }
}
