import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        Long ab = Long.parseLong(arr[0] + arr[1]);
        Long cd = Long.parseLong(arr[2] + arr[3]);
        System.out.println(ab + cd);
    }
}
