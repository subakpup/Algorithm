import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] arr = new boolean[20000001];
        for (int i = 0; i < n; i++) arr[Integer.parseInt(st.nextToken()) + 10000000] = true;

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int cnt = 0;

            if (arr[Integer.parseInt(st.nextToken()) + 10000000]) cnt++;
            sb.append(cnt).append(' ');
        }

        System.out.println(sb.toString());
    }
}