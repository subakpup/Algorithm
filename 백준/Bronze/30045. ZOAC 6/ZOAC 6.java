import java.util.*;
import java.io.*;

class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        while (n-- > 0) {
            String s = br.readLine();

            if (s.contains("01") || s.contains("OI")) ++cnt;
        }

        System.out.println(cnt);
    }
}