import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static class Student {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        ArrayList<Student> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Student(name, korean, english, math));
        }

        Collections.sort(list, comp);

        for(Student s : list) {
            sb.append(s.name).append("\n");
        }

        System.out.println(sb);
    }

    public static Comparator<Student> comp = new Comparator<>() {
        @Override
        public int compare(Student a, Student b) {
            if(a.korean == b.korean) {
                if(a.english == b.english) {
                    if(a.math == b.math) {
                        return a.name.compareTo(b.name);
                    } else {
                        return b.math - a.math;
                    }
                } else {
                    return a.english - b.english;
                }
            } else {
                return b.korean - a.korean;
            }
        }
    };
}
