import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int solve(String exps) {
        String[] sub = exps.split("-");
        int answer = Integer.MAX_VALUE;

        for(String s : sub) {
            String[] add = s.split("\\+");
            int sum = 0;
            for(String a : add) {
                sum += Integer.parseInt(a);
            }
            if(answer == Integer.MAX_VALUE) {
                answer = sum;
            } else {
                answer -= sum;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solve(s));
    }
}
