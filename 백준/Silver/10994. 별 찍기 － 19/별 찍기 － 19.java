import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;

    private static void draw(int n, int r, int c) {
        if (n == 1) {
            map[r][c] = '*';
            return;
        }

        int len = 4 * n - 3;

        for (int i = 0; i < len; i++) {
            map[r][c + i] = '*';
            map[r + len - 1][c + i] = '*';
            map[r + i][c] = '*';
            map[r + i][c + len - 1] = '*';
        }

        draw(n - 1, r + 2, c + 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int len = 4 * n - 3;
        map = new char[len][len];

        for (int i = 0; i < len; i++) Arrays.fill(map[i], ' ');

        draw(n, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}