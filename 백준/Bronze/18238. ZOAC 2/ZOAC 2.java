import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int cnt = 0;
        char cur = 'A';

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            int diff = Math.abs(target - cur);
            cnt += Math.min(diff, 26 - diff);
            cur = target;
        }

        System.out.println(cnt);
    }
}