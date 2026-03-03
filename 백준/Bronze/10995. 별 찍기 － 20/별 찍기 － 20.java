import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) sb.append(' ');
            for (int j = 0; j < n; j++) sb.append('*').append(' ');
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}