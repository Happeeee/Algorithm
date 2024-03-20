import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        for(String p : phone_book) {
            set.add(p);
        }
        
        for(String p : phone_book) {
            int n = p.length();
            for(int i = 1; i < n; i++) { // 자기 자신이 걸리니까, 마지막 문자는 포함x                 
                if(set.contains(p.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
