import java.util.*;

public class Main {
    private static String deleteZero(StringBuilder sb) {
        while(true) {
            if(sb.length() > 0 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            } else
                break;
        }

        if(sb.length() == 0)
            return "0";
        else
            return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> result = new ArrayList<>();

        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();

            for(char c : str.toCharArray()) {
                if(Character.isDigit(c))
                    sb.append(c);
                else {
                    if(sb.length() > 0) {
                        result.add(deleteZero(sb));
                        sb.setLength(0);
                    }
                }
            }

            if(sb.length() > 0)
                result.add(deleteZero(sb));
        }

       Collections.sort(result, (s1, s2) -> {
           if(s1.length() < s2.length()) return -1;
           else if(s1.length() > s2.length()) return 1; // 길이 먼저 비교
           else return s1.compareTo(s2); // 길이가 같다면 String.compareTo
       });

        for(String s : result)
            System.out.println(s);
    }
}
