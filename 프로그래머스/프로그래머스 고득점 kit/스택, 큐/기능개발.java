import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int day = 0, idx = 0;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();    
        
        for(int i : progresses) {
            q.add(i);
        }
                    
        while(!q.isEmpty()) {
            day++;
            
            int sum = 0;
            while(idx < progresses.length && progresses[idx] + speeds[idx] * day >= 100) {
                q.poll();
                idx++;
                sum++;
            }
            
            if(sum != 0) {
                list.add(sum);            
            }                        
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;            
    }
}
