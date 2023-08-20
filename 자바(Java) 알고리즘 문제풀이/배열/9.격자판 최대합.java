import java.util.*;

public class Main {    
    public static int solution(int n, int[][] map) {
        int max = -1;
        // 행, 열의 합
        for(int i = 0; i < n; i++) {
            int sum1 = 0, sum2 = 0;
            for(int j = 0; j < n; j++) {
                sum1 += map[i][j]; // 행
                sum2 += map[j][i]; // 열
            }
            max = Math.max(max, sum1);
            max = Math.max(max, sum2);
        }
        // 왼쪽 -> 오른쪽 대각선
        int sum1 = 0;
        for(int i = 0; i < n; i++)
            sum1 += map[i][i];
        max = Math.max(max, sum1);

        // 오른쪽 -> 왼쪽 대각선
        int y = n - 1, x = 0, sum2 = 0;
        for(int i = 0; i < n; i++)
            sum2 += map[y--][x++];
        max = Math.max(max, sum2);

        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, map));
    }
}
