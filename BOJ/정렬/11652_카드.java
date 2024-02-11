import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            Long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxCount = -1;
        Long minKey = Long.MAX_VALUE;
        for(Long key : map.keySet()) {
            if(map.get(key) > maxCount) {
                maxCount = map.get(key);
                minKey = key;
            } else if(map.get(key) == maxCount) {
                if(key < minKey)  {
                    minKey = key;
                }
            }
        }
        System.out.println(minKey);
    }
}
