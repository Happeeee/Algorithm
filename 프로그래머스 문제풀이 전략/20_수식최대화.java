import java.util.*;

class Solution {
    private static final String[][] precedences = {
        "+-*".split(""),
        "+*-".split(""),
        "-+*".split(""),
        "-*+".split(""),
        "*+-".split(""),
        "*-+".split("")
    };
    
    private long calculate(long lhs, long rhs, String op) {
        if(op.equals("+"))
            return lhs + rhs;
        else if(op.equals("*"))
            return lhs * rhs;
        else
            return lhs - rhs;
    }
    
    private long calculate(List<String> tokens, String[] precedence) {
        for(String op : precedence) {
            for(int i = 0; i < tokens.size(); i++) {
                if(tokens.get(i).equals(op)) {
                    long lhs = Long.parseLong(tokens.get(i - 1));
                    long rhs = Long.parseLong(tokens.get(i + 1));
                    long result = calculate(lhs, rhs, op);
                    
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.add(i - 1, String.valueOf(result));
                    i -= 2;                    
                }
            }
        }
        
        return Long.parseLong(tokens.get(0));
    }
    
    public long solution(String expression) {
        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList<>();
        
        while(tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
        
        long max = 0;
        
        for(String[] precedence : precedences) {
            // 참조변수를 넘겨주면 리스트가 변경되니까 복사해서 넘겨줘야함
            long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));
            if(value > max)
                max = value;            
        }
        
        return max;
    }
}
