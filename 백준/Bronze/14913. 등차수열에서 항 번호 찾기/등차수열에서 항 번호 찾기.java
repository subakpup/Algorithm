import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 1;
        if (d < 0) {
            while (a > k) {
                a += d;
                ++cnt;
           }
        }
        else {
            while (a < k) {
                a += d;
                ++cnt;
           }
        }

        if (a != k) System.out.println("X");
        else System.out.println(cnt);
    }
}