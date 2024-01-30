import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println(solution(s1, s2));
    }

    private static String solution(String s1, String s2) {
        TreeMap<Character, Integer> map1 = new TreeMap<>();
        TreeMap<Character, Integer> map2 = new TreeMap<>();
        for(char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for(char c : s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        if(mapToString(map1).equals(mapToString(map2))) {
            return "YES";
        } else {
            return "NO";
        }
    }

    private static String mapToString(TreeMap<Character, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for(char key : map.keySet()) {
            sb.append(key).append(map.get(key));
        }
        return sb.toString();
    }
}

// public class Main {
//     public static String solution(String s1, String s2) {
//         Map<Character, Integer> map1 = new HashMap<>();
//         Map<Character, Integer> map2 = new HashMap<>();
//         for(char c : s1.toCharArray())
//             map1.put(c, map1.getOrDefault(c, 0) + 1);
//         for(char c : s2.toCharArray())
//             map2.put(c, map2.getOrDefault(c, 0) + 1);

//         for(char key : map1.keySet()) {
//             if(!map2.keySet().contains(key) || map1.get(key) != map2.get(key))
//                 return "NO";
//         }

//         return "YES";
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String s1 = sc.next();
//         String s2 = sc.next();
//         System.out.println(solution(s1, s2));
//     }
// }
