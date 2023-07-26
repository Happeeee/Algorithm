import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int i = 666;

        for(;; i++) { // 666 부터 올라가면서
            if(Integer.toString(i).contains("666")) n--; // 종말의 수를 만나면 n 줄이기
            if(n == 0) break;
        }

        System.out.println(i); // n 번째 종말의 수
    }
}
