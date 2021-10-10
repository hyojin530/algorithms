import java.io.*;
import java.util.*;

public class BJ10825 {

    static class Student implements Comparable<Student> {
        public String name;
        public int kor, eng, math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student other) {
            if (kor != other.kor) {
                return other.kor - kor;
            } else if (eng != other.eng) {
                return eng - other.eng;
            } else if (math != other.math) {
                return other.math - math;
            }
            return name.compareTo(other.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Student[] list = new Student[num];
        for (int i = 0; i < num; i++) {
            String[] info = br.readLine().split(" ");
            list[i] = new Student(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]),
                    Integer.parseInt(info[3]));
        }
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(list[i].name + "\n");
        }
        System.out.println(sb.toString());
    }
}
