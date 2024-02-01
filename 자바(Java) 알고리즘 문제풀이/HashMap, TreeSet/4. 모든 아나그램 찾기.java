import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        System.out.println(solution(s, t));
    }

    private static int solution(String s, String t) {
        int lt = 0, count = 0;
        for(int rt = t.length(); rt <= s.length(); rt++) {
            if(isAnagram(s.substring(lt, rt), t)) {
                count++;
            }
            lt++;
        }
        return count;
    }

    private static boolean isAnagram(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for(char c : s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        return map1.equals(map2);
    }
}
