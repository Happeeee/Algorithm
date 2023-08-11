import java.util.*;
class Solution {    
    private List<Integer>[] adj;
    private boolean visited[];        
    
    private int dfs(int here, int no) {        
        visited[here] = true;
            
        int count = 1;
        for(int there : adj[here]) {
            if(!visited[there] && there != no) {
                count += dfs(there, no);                
            }                            
        }
        return count;                
    }
    
    public int solution(int n, int[][] wires) {                
        visited = new boolean[n + 1];
        adj = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();
        
        for(int i = 0; i < wires.length; i++) {          
            adj[wires[i][0]].add(wires[i][1]);
            adj[wires[i][1]].add(wires[i][0]);
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i++) {
            Arrays.fill(visited, false);
            int c1 = dfs(wires[i][0], wires[i][1]);
            int c2 = dfs(wires[i][1], wires[i][0]);
            min = Math.min(min, Math.abs(c1 - c2));
        }
                               
        return min;
    }
}
