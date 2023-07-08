import java.util.*;

class Solution {
    
    private List<String> split(String s, int length) {
        List<String> tokens = new ArrayList<>();
        
        for(int start = 0; start < s.length(); start += length) {
            int end = start + length;
            if(end > s.length()) end = s.length();
            tokens.add(s.substring(start, end));
        }
        
        return tokens;
    }

    private int compress(String s, int length) {
        StringBuilder sb = new StringBuilder();
        String last = "";
        int count = 0;
        
        for(String token : split(s, length)) {
            if(token.equals(last)) 
                count++;
            else {
                if(count > 1)
                    sb.append(count);
                sb.append(last); // 뒤까지 보고 같은 것이 없음을 확인한 뒤 추가할 수 있기 때문에 last
                last = token;
                count = 1;
            }                                                      
        }    
        
        if(count > 1) sb.append(count);
        sb.append(last); // 마지막 남은 last 추가
        
        return sb.length();
    }
    
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i <= s.length(); i++) {
            min = Math.min(min, compress(s, i));
        }
        
        return min;
    }
}
