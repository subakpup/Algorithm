import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static boolean[][] arr;

    // W = true, B = false
    private static void solve() {
        int answer = Integer.MAX_VALUE;

        Loop:
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                answer = Math.min(answer, paint(i, j));
                if (answer == 0) break Loop;
            }
        }

        System.out.println(answer);
    }

    private static int paint(int sx, int sy) {
        int cnt = 0;
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean expected = ((i + j) % 2 == 0);

                if (arr[sx + i][sy + j] != expected) ++cnt;
            }
        }

        return Math.min(cnt, 64 - cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'W') arr[i][j] = true;
            }
        }

        solve();

    }
}