import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int answer = 1;
        for(String key : map.keySet()) {
            answer *= map.get(key) + 1;            
        }
        
        return answer - 1;
    }
}

// key value 형태로 map에 저장
// keySet을 순회하면서, value + 1을 곱해간다 ex) (0, 1, 2) * (0, 1)
// 그리고 아무것도 안입는 경우인 0,0,0 ... 의 경우의 수 1을 빼기
