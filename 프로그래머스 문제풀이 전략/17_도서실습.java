import java.util.*;

class Solution {
    private static final char[] arr = "AEIOU".toCharArray();
    
    private void generate(String word, List<String> words) {        
        words.add(word);
        
        if(word.length() == 5) return;
        
        for(char c : arr) {
            generate(word + c, words);
        }            
    }
    
    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generate("", words);
        return words.indexOf(word);
    }
}
