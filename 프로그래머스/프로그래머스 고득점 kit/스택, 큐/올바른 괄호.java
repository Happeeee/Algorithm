import java.util.*;

class Solution {
    boolean solution(String str) {
        Stack<Integer> s = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == '(') {
                s.push(1);
            } else {
                if(s.isEmpty()) {
                    return false;
                }
                s.pop();
            }
        }
        
        if(s.isEmpty()) return true;
        else return false;
    }
}
