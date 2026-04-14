import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            a %= 10;

            if (a == 0) {
                sb.append(10).append('\n');
            } else {
                b %= 4;

                if (b == 0) b = 4;

                int result = (int) Math.pow(a, b) % 10;
                sb.append(result).append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}