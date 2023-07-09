class Solution {
    public int solution(String s) {        
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int i = 0;
        
        while(i < arr.length) {                        
            char c = arr[i];
            
            if(Character.isDigit(c)) {
                sb.append(c); i++;
                continue;
            }
            
            switch(c) {
                case 'z':
                    sb.append(0); i += 4;
                    break;
                case 'o':
                    sb.append(1); i += 3;
                    break;
                case 'e':
                    sb.append(8); i += 5;
                    break;
                case 'n':
                    sb.append(9); i += 4;
                    break;
                case 't':
                    if(arr[i + 1] == 'w') {
                        sb.append(2); i += 3;
                    }                        
                    else {
                        sb.append(3); i += 5;
                    }                        
                    break;
                case 'f':
                    if(arr[i + 1] == 'o') {
                        sb.append(4); i += 4;
                    }                        
                    else {
                        sb.append(5); i += 4;
                    }                        
                    break;
                case 's':
                    if(arr[i + 1] == 'i') {
                        sb.append(6); i += 3;
                    }                        
                    else {
                        sb.append(7); i += 5;
                    }                        
            }                        
        }
        
        return Integer.parseInt(sb.toString());
    }
}

// class Solution { // (해답) 복잡도는 더 높지만 간결하고 직관적인 코드 
//     private static final String[] words = {
//         "zero", "one", "two", "three", "four", "five",
//         "six", "seven", "eight", "nine", "ten"
//     };
    
//     public int solution(String s) {        
//         for(int i = 0; i < words.length; i++) {
//             s = s.replace(words[i], Integer.toString(i));
//         }
        
//         return Integer.parseInt(s);
//     }
// }
