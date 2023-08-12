import java.util.*;

class Solution {
    private int[] visited;
    private List<Integer>[] adj;
    private int max = -1;
    
    private void bfs(int u) {
        Queue<Integer> q = new LinkedList<>();
        visited[u] = 1;
        q.add(u);
        
        while(!q.isEmpty()) {
            int v = q.poll();
            
            for(int there : adj[v]) {
                if(visited[there] == 0) {
                    visited[there] = visited[v] + 1;
                    max = visited[there];
                    q.add(there);
                }
            }
        }
    }

    public int solution(int n, int[][] edge) {        
        visited = new int[n];        
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++) 
            adj[i] = new ArrayList<>();
            
        for(int i = 0; i < edge.length; i++) {                        
            adj[edge[i][0] - 1].add(edge[i][1] - 1);
            adj[edge[i][1] - 1].add(edge[i][0] - 1);
        }
        
        bfs(0);                
        
        int count = 0;
        for(int i = 0; i < n; i++) 
            if(visited[i] == max) count++;
                
        return count;
    }
}
