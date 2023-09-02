import java.util.*;

public class Main {
    public static int solution(int[][] arr, int n, int m) {
        int count = 0;
        for(int i = 1; i <= n; i++) { // i번 학생 기준으로
            for(int j = 1; j <= n; j++) { // 다른 학생들과 비교
                if(i == j) continue;
                boolean flag = true;
                for(int k = 0; k < m; k++) { // m번의 시험에서
                    int iRank = 0, jRank = 0;
                    for(int a = 0; a < n; a++) { // i, j 학생의 등수
                        if(arr[k][a] == i) iRank = a;
                        if(arr[k][a] == j) jRank = a;
                    }

                    if(iRank > jRank) {
                        flag = false;
                        break;
                    }
                }
                if(flag) count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(arr, n, m));
    }
}

