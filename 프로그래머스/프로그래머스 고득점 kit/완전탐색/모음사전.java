class Solution {    
    private final char[] arr = {'A', 'E', 'I', 'O', 'U'};
    private boolean[] visited;
    private int count;
    private int answer;
    
    private void dfs(String now, String word, int depth) {
        count++;
        if(now.equals(word)) {
            answer = count - 1;
            return;
        }
        
        if(depth == 5) return;
        
        for(int i = 0; i < 5; i++) {
            dfs(now + arr[i], word, depth + 1);
        }
    }
    
    public int solution(String word) {                
        String str = "";
        dfs(str, word, 0);
        
        return answer;
    }
}
