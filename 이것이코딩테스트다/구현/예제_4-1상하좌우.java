import java.util.*;

public class Main {

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    private static final char[] moveTypes = {'L', 'R', 'U', 'D'};
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);      
        int n = sc.nextInt();      
        sc.nextLine();
      
        String[] plans = sc.nextLine().split(" ");
        int x = 1, y = 1;      
      
        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);            
            int nx = -1, ny = -1;
            for (int j = 0; j < 4; j++) {
                if (plan == moveTypes[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
          
            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
            
            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);
    }

}
