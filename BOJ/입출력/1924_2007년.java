import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int sum = 0;

        for(int i = 1; i < month; i++) {
            sum += daysOfMonth[i];
        }
        sum += day;
        System.out.println(days[sum%7]);
    }
}
