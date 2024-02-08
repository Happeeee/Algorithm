import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(solution(list, n));
    }

    private static Character solution(ArrayList<Integer> list, int n) {
        Collections.sort(list);
        for(int i = 0; i < n - 1; i++) {
            if(list.get(i) == list.get(i + 1)) {
                return 'D';
            }
        }
        return 'U';
    }

    // Map 이용 풀이
    //   private static Character solution(ArrayList<Integer> list, int n) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for(int i : list) {
    //         if(map.containsKey(i)) {
    //             return 'D';
    //         } else {
    //             map.put(i, 1);
    //         }
    //     }
    //     return 'U';
    // }
}
