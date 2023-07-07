class Solution {
    public int[] solution(long n) {        
        
        String str = Long.toString(n);
        StringBuilder sb = new StringBuilder(str);
        
        sb.reverse();        
        str = sb.toString();
        
        char[] arr = str.toCharArray();
        int[] answer = new int[arr.length];
        
        for(long i = 0; i < arr.length; i++) {
            answer[(int)i] = arr[(int)i] - '0';
        }
        
        return answer;
    }
}
