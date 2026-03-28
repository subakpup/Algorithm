import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();
        int[] arr = new int[5];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'u') ++arr[0];
            else if (ch == 'o') ++arr[1];
            else if (ch == 's') ++arr[2];
            else if (ch == 'p') ++arr[3];
            else if (ch == 'c') ++arr[4];
        }

        Arrays.sort(arr);
        System.out.println(arr[0]);
    }
}