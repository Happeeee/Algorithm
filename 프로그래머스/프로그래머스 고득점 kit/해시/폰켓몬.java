import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int c = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        if(map.size() >= c) return c;
        else return map.size();        
    }
}
