import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {              
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) 
            map.put(players[i], i);    
        
        for(int i = 0; i < callings.length; i++) {
            int front = map.get(callings[i]) - 1;                        
            int back = map.get(callings[i]);
            
            String temp = players[back];
            players[back] = players[front];
            players[front] = temp;
            
            map.put(players[back], back);
            map.put(players[front], front);
        }
        
        return players;
    }
}
