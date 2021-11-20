import java.io.*;

public class BJ1057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int Kim = Integer.parseInt(info[1]);
        int Lim = Integer.parseInt(info[2]);
        int count = 0;

        while (Kim != Lim) {
            Kim = (Kim + 1) / 2;
            Lim = (Lim + 1) / 2;
            count++;
        }
        System.out.println(count);
    }

}
