import java.util.*;

public class Solution {
    public int[] solution(int []arr) {                
        Queue<Integer> queue = new LinkedList<>();
        
        int prev = -1;
        for(int i = 0; i < arr.length; i++) {
            if(prev != arr[i]) {
                queue.add(arr[i]);
                prev = arr[i];
            } else 
                continue;                            
        }
        
        int[] answer = new int[queue.size()];
        
        int i = 0;
        
        while(!queue.isEmpty()) {
            answer[i] = queue.poll();
            i++;
        }
                    
        return answer;
    }
}
