import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        if (n == 1) {
            sb.append('*');
        } else {
            for (int i = 0; i < n - 1; i++) sb.append(' ');
            sb.append('*').append('\n');

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 2; j++) sb.append(' ');
                sb.append('*');
                for (int j = 0; j < 2 * i + 1; j++) sb.append(' ');
                sb.append('*');
                sb.append('\n');
            }
        }
        
        System.out.println(sb.toString());
    }
}