import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    private static String solve(String s) {
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') ++cnt;
            else {
                if (cnt <= 0) return "NO";
                --cnt;
            }
        }

        if (cnt == 0) return "YES";
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            sb.append(solve(s)).append('\n');
        }

        System.out.println(sb.toString());
    }
}