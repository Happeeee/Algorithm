class Solution {
    private int n;
    private int[][] adj;
    private boolean[] visited;
    
    private void dfs(int u) {
        visited[u] = true;
        
        for(int i = 0; i < n; i++) {
            if(i == u) continue;
            if(!visited[i] && adj[u][i] == 1)
                dfs(i);
        }
    }
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.adj = computers;
        this.visited = new boolean[n];
        
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }                    
        }
        return count;                
    }
}
