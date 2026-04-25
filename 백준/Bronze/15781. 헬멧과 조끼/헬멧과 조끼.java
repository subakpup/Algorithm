import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int helmet = 0;
        for (int i = 0; i < n; i++) helmet = Math.max(helmet, Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        int vest = 0;
        for (int j = 0; j < m; j++) vest = Math.max(vest, Integer.parseInt(st.nextToken()));

        System.out.println(helmet + vest);
    }
}