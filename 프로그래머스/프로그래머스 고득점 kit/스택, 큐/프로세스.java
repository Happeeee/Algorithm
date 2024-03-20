import java.util.*;

class Solution {
    
    class Job {
        int p, l;
        
        Job(int p, int l) {
            this.p = p;
            this.l = l;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Job> q = new LinkedList<>();
        int[] count = new int[10];
        int order = 0;
        
        for(int i = 0; i < priorities.length; i++) {
            q.add(new Job(priorities[i], i));
            count[priorities[i]]++;
        }
        
        while(!q.isEmpty()) {
            Job job = q.poll();
            
            boolean flag = true;
            for(int i = job.p + 1; i < 10; i++) {
                if(count[i] > 0) {
                    q.add(job);
                    flag = false;
                    break;
                }
            }
            if(!flag) continue;
            
            order++;
            count[job.p]--;
            
            if(job.l == location) {                
                return order;
            }
        }
        
        return 0;
    }
}

// 1. 우선순위, 위치를 담는 Class를 만들어서 큐에 저장
// 2. count[] 배열을 두고 우선순위 별로 개수 측정
// 3. q.poll() -> 우선순위 확인 -> count 뒷부분 순회하면서 자신이 가장 높은 우선순위인지 확인
// 4. 맞으면 개수 측정, 아니면 뒤에 다시 삽입
