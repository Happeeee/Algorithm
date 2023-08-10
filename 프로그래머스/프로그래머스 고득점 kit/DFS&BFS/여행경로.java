import java.util.*;

class Solution {
    private String[][] tickets;
    private List<String> paths = new ArrayList<>();
    private boolean[] visited;  // 티켓을 사용했느냐 아니냐
    
    private void dfs(String now, int depth, String path) {
        if(depth == tickets.length) {
            paths.add(path.toString());
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(now)) {
                visited[i] = true;                            
                dfs(tickets[i][1], depth + 1, path + " " + tickets[i][1]);
                visited[i] = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {          
        this.tickets = tickets;
        visited = new boolean[tickets.length];

        dfs("ICN", 0, "ICN");
        
        Collections.sort(paths);
        
        return paths.get(0).split(" ");
    }    
}
