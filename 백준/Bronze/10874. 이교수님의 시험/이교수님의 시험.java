import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] answers = new int[10];
        for (int i = 0; i < 10; i++) {
            answers[i] = i % 5 + 1;
        }

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            boolean flag = true;
            for (int j = 0; j < 10; j++) {
                if (answers[j] != Integer.parseInt(st.nextToken())) {
                    flag = false;
                    break;
                }
            }

            if (flag) sb.append(i).append('\n');
        }

        System.out.println(sb.toString());
    }
}