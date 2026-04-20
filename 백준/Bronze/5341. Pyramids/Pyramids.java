import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int total = 0;
            for (int i = 1; i <= n; i++) total += i;

            sb.append(total).append('\n');
        }

        System.out.println(sb.toString());
    }
}