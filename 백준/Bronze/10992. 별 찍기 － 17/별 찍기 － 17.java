import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) sb.append(' ');
        sb.append('*');

        if (n > 1) {
            sb.append('\n');

            for (int i = 2; i < n; i++) {
                for (int j = 0; j < n - i; j++) sb.append(' ');
                sb.append('*');
                for (int j = 0; j < (i - 1) * 2 - 1; j++) sb.append(' ');
                sb.append('*').append('\n');
            }

            for (int i = 0; i < n * 2 - 1; i++) sb.append('*');
        }
        System.out.println(sb.toString());
    }
}