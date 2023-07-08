class Solution {
    private int countZero(String s) {
        int count = 0;
        
        for(char c : s.toCharArray()) 
            if(c == '0') count++;    
        
        return count;
    }
    
    public int[] solution(String s) {                        
        int changes = 0, zeros = 0;
        
        String str = s;
        
        while(!str.equals("1")) {            
            int zero = countZero(str);            
            int length = str.length() - zero;
            
            str = Integer.toString(length, 2);
            
            changes++; zeros += zero;                        
        }
        
        int[] answer = {changes, zeros};
        return answer;
        
    }
}
