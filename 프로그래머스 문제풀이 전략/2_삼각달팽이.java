import java.util.*;

class Solution {    
    public int[] solution(int n) {
        //int[] answer = {};        
        int x = 0, y = 0, count = 0;
        
        int[][] arr = new int[n + 2][n + 2];
                        
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
