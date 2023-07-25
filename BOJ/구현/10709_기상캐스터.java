import java.util.*;

public class Main {

    private static char[][] map = new char[100][100];
    private static int[][] distance = new int[100][100];
    private static int h, w;

    private static void getDistance(int y, int x) {
        for(int i = x; i < w; i++) {
            if(map[y][i] == 'c') continue;

            int dis = i - x;
            if(distance[y][i] == -1)
                distance[y][i] = dis;
            else
                distance[y][i] = Math.min(distance[y][i], dis);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        h = sc.nextInt();
        w = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < h; i++) {
            String str = sc.nextLine();
            for(int j = 0; j < w; j++) {
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'c') distance[i][j] = 0;
                else distance[i][j] = -1;
            }
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(map[i][j] == 'c')
                    getDistance(i, j);
            }
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// 위 코드는 모든 c로부터의 거리를 계산하므로 비효율적
// 거리를 한번씩만 계산하도록 수정
// import java.util.*;

// public class Main {
//     private static int[][] distance = new int[100][100];

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int h = sc.nextInt();
//         int w = sc.nextInt();
//         sc.nextLine();

//         for(int i = 0; i < h; i++) {
//             String str = sc.nextLine();
//             for(int j = 0; j < w; j++) {
//                 if(str.charAt(j) == 'c') distance[i][j] = 0;
//                 else distance[i][j] = -1;
//             }
//         }

//         for(int i = 0; i < h; i++) {
//             int count = 0;
//             for(int j = 0; j < w; j++) {
//                 if(distance[i][j] == 0)
//                     count = 1;
//                 else if(distance[i][j] == -1 && count > 0)
//                     distance[i][j] = count++;
//             }
//         }

//         for(int i = 0; i < h; i++) {
//             for(int j = 0; j < w; j++) {
//                 System.out.print(distance[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }
// }

