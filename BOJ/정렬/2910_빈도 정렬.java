import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        HashMap<Integer,Integer> count = new HashMap<>();
        HashMap<Integer,Integer> index = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if(count.containsKey(num))
                count.put(num, count.get(num) + 1);
            else {
                count.put(num, 1);
                index.put(num, i);
            }
        }

        List<Integer> keySet = new ArrayList<>(index.keySet());

        Collections.sort(keySet, (key1, key2) -> {
            if(count.get(key1) > count.get(key2)) return -1;
            else if(count.get(key1) < count.get(key2)) return 1;
            else {
                if(index.get(key1) < index.get(key2)) return -1;
                else return 1;
            }
        });

        for(int key : keySet) {
            for(int i = 0; i < count.get(key); i++) {
                System.out.print(key + " ");
            }
        }

    }
}
