import java.util.*;

public class Main {
    public static char solution(String str) {
        char reader = ' '; int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for(char key : map.keySet()) {
            if(map.get(key) > max) {
                reader = key;
                max = map.get(key);
            }
        }
        return reader;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(solution(str));
    }
}

