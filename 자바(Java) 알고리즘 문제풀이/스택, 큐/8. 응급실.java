import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Patient {
    int id;
    int value;

    public Patient(int id, int value) {
        this.id = id;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Queue<Patient> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            q.add(new Patient(i, value));
        }
        System.out.println(solution(m, q));
    }

    private static int solution(int m, Queue<Patient> q) {
        int count = 0;
        while(true) {
            Patient patient = q.poll();

            boolean exist = false;
            for(Patient tmp : q) {
                if(patient.value < tmp.value) {
                    exist = true;
                    break;
                }
            }

            if(exist) {
                q.add(patient);
                continue;
            }
            
            if(patient.id == m) {
                return count + 1;
            }
            count++;
        }
    }
}
