import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int moveLength = Integer.parseInt(br.readLine());
        int[] moves = new int[moveLength];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < moveLength; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> basket = new Stack<>();
        int explosion = 0;
        for(int pos : moves) {
            int doll = 0;
            for(int row = 0; row < n; row++) {
                if(arr[row][pos - 1] != 0) {
                    doll = arr[row][pos - 1];
                    arr[row][pos - 1] = 0;
                    break;
                }
            }
            if(doll == 0) continue;

            if(!basket.isEmpty() && basket.peek() == doll) {
                basket.pop();
                explosion += 2;
            } else {
                basket.push(doll);
            }
        }
        System.out.println(explosion);
    }
}
