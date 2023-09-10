import java.util.*;

public class Main {
    public static String solution(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(char c : s1.toCharArray())
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        for(char c : s2.toCharArray())
            map2.put(c, map2.getOrDefault(c, 0) + 1);

        for(char key : map1.keySet()) {
            if(!map2.keySet().contains(key) || map1.get(key) != map2.get(key))
                return "NO";
        }

        return "YES";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(solution(s1, s2));
    }
}

// public class Main {
//     public static String solution(String s1, String s2) {
//         Map<Character, Integer> map = new HashMap<>();
//         for(char c : s1.toCharArray())
//             map.put(c, map.getOrDefault(c, 0) + 1);

//         for(char c : s2.toCharArray()) {
//             if(!map.containsKey(c) || map.get(c) == 0) return "NO";
//             map.put(c, map.get(c) - 1);
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
