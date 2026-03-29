import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        boolean[] visited = new boolean[s.length()];

        int cnt = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (visited[i]) continue;

            if (s.charAt(i) == s.charAt(i + 1) - 1 && s.charAt(i) == s.charAt(i + 2) - 2) {
                visited[i] = true;
                visited[i + 1] = true;
                visited[i + 2] = true;

                if (i + 3 < s.length() && s.charAt(i) == s.charAt(i + 3) - 3) {
                    visited[i + 3] = true;
                    continue;
                }

                ++cnt;
            }
        }

        System.out.println(cnt);
    }
}