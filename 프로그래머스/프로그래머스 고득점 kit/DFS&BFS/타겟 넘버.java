class Solution {        
    private int[] numbers;
    private int target;
    private int count;
    
    private void dfs(int index, int sum) {
        if(index == numbers.length) {
            if(sum == target) count++;
            return;
        }
        
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0);
        
        return count;
    }
}
