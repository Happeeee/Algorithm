class Solution {
    boolean solution(String s) {    
        int cnt_p = 0, cnt_y = 0;
        s = s.toLowerCase();
        
        for(char c : s.toCharArray()) {                     
            if(c == 'p') cnt_p++;
            else if(c == 'y') cnt_y++;            
        }                 
        
        if(cnt_p == cnt_y) return true;
        else return false;       
    }
}

// class Solution {
//     boolean solution(String s) {
//         s = s.toLowerCase();
           // (원본 문자열의 길이) - (p를 제거한 문자열의 길이) = p의 개수!
//         return s.length() - s.replace("p", "").length() == s.length() - s.replace("y", "").length();                                               
//     }
// }
