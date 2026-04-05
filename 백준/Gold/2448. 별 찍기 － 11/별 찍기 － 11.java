import java.util.*;
import java.io.*;

public class Main {

    static char[][] map;

    private static void pattern(int r, int c) {
        map[r][c] = '*';
        map[r+1][c-1] = '*'; map[r+1][c+1] = '*';
        for (int i = c-2; i <= c+2; i++) map[r+2][i] = '*';
    }

    private static void draw(int n, int r, int c) {
        if (n == 3) {
            pattern(r, c);
            return;
        }

        int size = n / 2;

        draw(size, r, c);
        draw(size, r + size, c - size);
        draw(size, r + size, c + size);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new char[n][n * 2 - 1];
        for (int i = 0; i < n; i++) Arrays.fill(map[i], ' ');

        draw(n, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map[i]).append('\n');
        }

        System.out.print(sb.toString());
    }
}