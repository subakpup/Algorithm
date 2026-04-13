import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String s = br.readLine();
            int n = Integer.parseInt(s);
            
            StringBuilder r = new StringBuilder(s);
            int m = Integer.parseInt(r.reverse().toString());

            s = String.valueOf(n + m);
            r = new StringBuilder(s);

            if (s.equals(r.reverse().toString())) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb.toString());
    }
}