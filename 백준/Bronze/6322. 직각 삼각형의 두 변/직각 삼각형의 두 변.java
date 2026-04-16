import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == b && b == c && c == a && a == 0) break;

            sb.append("Triangle #").append(++t).append('\n');

            if (c == -1) {
                sb.append("c = ").append(String.format("%.3f", Math.pow((a * a + b * b), 0.5))).append("\n\n");
            } else if (Math.max(a, b) >= c) {
                sb.append("Impossible.\n\n");
            } else if (a == -1) {
                sb.append("a = ").append(String.format("%.3f", Math.pow((c * c - b * b), 0.5))).append("\n\n");
            } else if (b == -1) {
                sb.append("b = ").append(String.format("%.3f", Math.pow((c * c - a * a), 0.5))).append("\n\n");
            }
        }

        System.out.println(sb.toString());
    }
}