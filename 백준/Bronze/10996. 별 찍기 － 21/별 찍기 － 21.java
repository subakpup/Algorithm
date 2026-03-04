import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println('*');
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) sb.append('*').append(' ');
            sb.append('\n');
            for (int j = 0; j < n / 2; j++) sb.append(' ').append('*');
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}