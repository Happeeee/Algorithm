import java.util.*;
public class Main {
    private static String changeToTime(int sum) {
        StringBuilder sb = new StringBuilder();
        sb.append(sum / 60);
        if(sb.length() == 1) sb.insert(0, "0");

        sb.append(":");

        sb.append(sum % 60);
        if(sb.length() == 4) sb.insert(3, "0");

        return sb.toString();
    }
    
    private static int changeToSecond(String time) {
        return Integer.parseInt(time.substring(3, 5)) + Integer.parseInt(time.substring(0, 2)) * 60;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum1 = 0, sum2 = 0, score1 = 0, score2 = 0, prev = 0;

        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++) {
            String str = sc.nextLine();
            int team = str.charAt(0) - '0';
            String time = str.substring(2);

            if(score1 > score2) // 지금까지 누가 이기고 있었는지에 따라 어떤 팀에 더해줄지 결정
                sum1 += changeToSecond(time) - prev;
            else if(score2 > score1)
                sum2 += changeToSecond(time) - prev;

            if(team == 1) score1++;
            else score2++;
            
            prev = changeToSecond(time);
        }

        if(score1 > score2)  // 지금까지 누가 이기고 있었는지에 따라 어떤 팀에 더해줄지 결정
            sum1 += changeToSecond("48:00") - prev;
        else if(score2 > score1)
            sum2 += changeToSecond("48:00") - prev;

        System.out.println(changeToTime(sum1));
        System.out.println(changeToTime(sum2));
    }
}
