import java.util.*;

class Solution {    
    private int[][] dungeons;
    private boolean[] visited;
    private int answer = -1;
    
    private void dfs(int depth, int k) {                            
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;                                                
                dfs(depth + 1, k - dungeons[i][1]);                
                visited[i] = false;                                
            }
        }
        answer = Math.max(answer, depth);
    }
        
    public int solution(int k, int[][] dungeons) {        
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        
        dfs(0, k);                
        
        return answer;
    }
}

// 첫 풀이 - 불필요한 순열, 불필요한 종료조건
// import java.util.*; 

// class Solution {    
//     private int[][] dungeons;
//     private List<Integer> counts = new ArrayList<>();
//     private List<Integer> path = new ArrayList<>();
//     private boolean[] visited;

//     private void permutation(int depth, int k) {
//         if(depth == dungeons.length) {
//             counts.add(path.size());
//             return;
//         }

//         boolean canGo = false;        
//         for(int i = 0; i < dungeons.length; i++) 
//             if(dungeons[i][0] <= k)
//                 canGo = true;

//         if(!canGo) {
//             counts.add(path.size());
//             return;
//         }

//         for(int i = 0; i < visited.length; i++) {
//             if(!visited[i] && dungeons[i][0] <= k) {
//                 visited[i] = true;
//                 path.add(i);
//                 k -= dungeons[i][1];

//                 permutation(depth + 1, k);

//                 visited[i] = false;
//                 path.remove(path.size() - 1);
//                 k += dungeons[i][1];
//             }
//         }                
//     }

//     public int solution(int k, int[][] dungeons) {        
//         this.dungeons = dungeons;
//         visited = new boolean[dungeons.length];

//         permutation(0, k);

//         Collections.sort(counts);

//         return counts.get(counts.size() - 1);                        
//     }
// }
