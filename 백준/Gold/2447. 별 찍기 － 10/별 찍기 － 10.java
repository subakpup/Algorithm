import java.util.*;
import java.io.*;

public class Main {
    
    static char[][] map;

    private static void draw(int n, int r, int c) {
        if (n == 1) {
            map[r][c] = '*';
            return;
        }

        int len = n / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                draw(len, r + (i * len), c + (j * len));
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(map[i], ' ');

        draw(n, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) sb.append(map[i][j]);
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}