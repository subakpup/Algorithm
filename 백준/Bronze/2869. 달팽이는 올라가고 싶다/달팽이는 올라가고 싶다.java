import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        /*
            Ax - B(x-1) = V
            Ax - Bx + B = V
            (A - B)x = V - B
            x = (V - B) / (A - B)
        */
        int answer = (v - b) / (a - b);

        if ((v - b) % (a - b) != 0) answer++;
        System.out.println(answer);
    }
}