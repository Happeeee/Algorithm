import java.util.*;

// 프로그래머스 문제 풀이 전략
// p.84 코드 참고

class Solution {    
    public int[] solution(int n) {
        //int[] answer = {};        
        int x = 0, y = 0, count = 0;
        
        int[][] arr = new int[n + 2][n + 2]; // 배열 크기 주의!
                        
        while(true) {    
            
            while(true) { // 아래 방향        
                arr[y][x] = ++count;
                if(arr[y + 1][x] != 0 || y + 1 == n) break; // 이미 채워졌거나 크기를 넘은 경우
                y++;                
            }
            
            if(arr[y][x + 1] != 0 || x + 1 == n) break; // 오른쪽으로 갈 수 있는지 확인
            x++;
            
            while(true) { // 오른 방향        
                arr[y][x] = ++count;
                if(arr[y][x + 1] != 0 || x + 1 == n) break; // 이미 채워졌거나 크기를 넘은 경우
                x++;                
            }
            
            if(arr[y - 1][x - 1] != 0) break; // 위쪽으로 갈 수 있는지 확인
            x--; y--;
            
            while(true) { // 윗 방향
                arr[y][x] = ++count;
                if(arr[y - 1][x - 1] != 0) break;
                x--; y--;
            }
            
            if(arr[y + 1][x] != 0 || y + 1 == n) break; // 다시 아래쪽으로 갈 수 있는지 확인
            y++;
        }
                        
        int[] result = new int[count];
            
        int index = 0;
            
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {                
                result[index++] = arr[i][j];                    
            }
        }
                                
        return result;                
    }
}

// dx, dy를 이용하여 개선한 코드
// import java.util.*;

// class Solution {    
//     private static final int[] dx = {0, 1, -1};
//     private static final int[] dy = {1, 0, -1};
    
//     public int[] solution(int n) {
//         int x = 0, y = 0, d = 0, count = 1; // x, y 위치, d 방향
//         int arr[][] = new int[n][n];
        
        
//         while(true) {
//             arr[y][x] = count++; // 숫자 대입
                
//             int nx = x + dx[d];                
//             int ny = y + dy[d]; // 다음 위치
                
//             // 아래, 오른쪽은 최대 n - 1까지, 왼쪽 위 방향은 최대 0, 0 까지, 세 경우 모두 다음 칸에 값이 없을 때 까지
//             if(nx == n || ny == n || nx == -1 || ny == -1 || arr[ny][nx] != 0) {
//                 d = (d + 1) % 3; // 방향 전환      
                    
//                 nx = x + dx[d]; // 방향 전환 이후 더 갈 수 있는지 검사하기 위해 다음 위치 계산
//                 ny = y + dy[d];
//                 if(nx == n || ny == n || nx == -1 || ny == -1 || arr[ny][nx] != 0) break;
//             }
            
//             x = nx; // break 안걸렸다면 다음 위치 부터 다시 반복
//             y = ny;
//         }
        
//         int[] result = new int[count - 1];
//         int index = 0;
        
//         for(int i = 0; i < n; i++) {
//             for(int j = 0; j <= i; j++) {
//                 result[index++] = arr[i][j];
//             }
//         }
        
//         return result;
        
//     }
// }
