class Solution {
    public String solution(String s, int n) {
        char[] arr = new char[s.length()];
        
        arr = s.toCharArray();
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == ' ') continue;
            
            char c = (char)(arr[i] + n);
            
            if(arr[i] >= 'A' && arr[i] <= 'Z') {                               
                if(c > 'Z') 
                    c -= 26;
            }
            
            if(arr[i] >= 'a' && arr[i] <= 'z') {                               
                if(c > 'z') 
                    c -= 26;
            }
            
            arr[i] = c;
        }
        
        String answer = new String(arr);;                
        
        return answer;
    }
}
