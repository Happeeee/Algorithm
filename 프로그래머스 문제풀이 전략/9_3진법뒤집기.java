class Solution {
    public int solution(int n) {        
        
        String three = Integer.toString(n, 3); // n을 3진법으로 표현된 문자열로
        StringBuilder sb = new StringBuilder(three);
        
        sb.reverse();    
                
        return Integer.parseInt(sb.toString(), 3); // 3진법으로 표현된 문자열을 정수로
    }
}
