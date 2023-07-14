import java.util.*;

class Solution {
    private static final int[] candidate1 = {1, 2, 3, 4, 5};
    private static final int[] candidate2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] candidate3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int[] counts = new int[3];
        List<Integer> list = new ArrayList<>();
        int max = -1;
    
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == candidate1[i % 5])
                counts[0]++;
            if(answers[i] == candidate2[i % 8])
                counts[1]++;
            if(answers[i] == candidate3[i % 10])
                counts[2]++;            
        }
        
        max = Math.max(counts[0], Math.max(counts[1], counts[2]));
        
        for(int i = 0; i < 3; i++) {
            if(counts[i] == max)
                list.add(i + 1);
        }
                
        int[] result = new int[list.size()];
        
        int index = 0;
        for(int i : list)
            result[index++] = i;
                        
        return result;
    }
}
