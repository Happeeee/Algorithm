import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Person {
        int weight;
        int height;

        Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] arr = new Person[n];
        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            arr[i] = new Person(weight, height);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i].weight < arr[j].weight && arr[i].height < arr[j].height) {
                    answer[i]++;
                }
            }
        }

        for(int i : answer) {
            System.out.print(i + " ");
        }
    }
}
