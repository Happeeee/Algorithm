import java.util.*;

public class Main {  
    private static int[][] map;        
    
    private static String compress(int y, int x, int length) {
        
        for(int i = y; i < y + length; i++) {
            for(int j = x; j < x + length; j++) {
                if(map[y][x] != map[i][j]) {                      
                    StringBuilder sb = new StringBuilder();
                    
                    sb.append("(")
                    .append(compress(y, x, length/2))
                    .append(compress(y, x + length/2, length/2))
                    .append(compress(y + length/2, x, length/2))
                    .append(compress(y + length/2, x + length/2, length/2))
                    .append(")");
                    
                    return sb.toString();
                }
            }
        }                
        
        if(map[y][x] == 1) return "1";
        else return "0";        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                
        int n = sc.nextInt();    
        sc.nextLine();
        map = new int[n][n];
                
        for(int i = 0; i < n; i++) {
            String str = sc.nextLine();
            
            for(int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
                        
        System.out.println(compress(0, 0, n));
                                
    }       
}
