class Solution {            
    private int min = Integer.MAX_VALUE;
    private String[] words;
    private boolean[] visited;

    private boolean canGo(String b, String t) {
        int count = 0;
        for(int i = 0; i < b.length(); i++) {
            if(b.charAt(i) != t.charAt(i)) {
                count++;
            }
        }
        if(count == 1) return true;
        else return false;
    }

    private void dfs(int depth, String begin, String target) {      
        if(begin.equals(target)) {
            min = Math.min(min, depth);
            return;
        }                 

        for(int i = 0; i < words.length; i++) {
            if(!visited[i] && canGo(begin, words[i])) {
                visited[i] = true;
                dfs(depth + 1, words[i], target);
                visited[i] = false;
            }  
        }
    }

    public int solution(String begin, String target, String[] words) {        
        this.words = words;
        this.visited = new boolean[words.length];        

        dfs(0, begin, target);

        if(min == Integer.MAX_VALUE) return 0;
        else return min;
    }
}
