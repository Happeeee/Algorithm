import java.util.*;

class Solution {
    private List<Character> list = new ArrayList<>();
    private List<Character> output = new ArrayList<>();
    private Set<Integer> set = new HashSet<>();
    private boolean[] visited;
    private int n;
    
    private boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;
        if(num == 2) return true;
        
        int count = 0;
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }
        
        return true;    
    }
    
    private void permutation(int r, int depth) {
        if(depth == r) {
            StringBuilder sb = new StringBuilder();
            for(char c : output) 
                sb.append(c);
            
            int num = Integer.parseInt(sb.toString());
            
            if(isPrime(num)) set.add(num);
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output.add(list.get(i));
                permutation(r, depth + 1);
                visited[i] = false;
                output.remove(output.size() - 1);
            }
        }
    }
    
    public int solution(String numbers) {    
        n = numbers.length();
        visited = new boolean[n];        
        for(char c : numbers.toCharArray()) 
            list.add(c);
        
        for(int i = 1; i <= n; i++) 
            permutation(i, 0);
                
        return set.size();            
    }
}
