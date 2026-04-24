import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            String s = br.readLine();

            if (s.contains("FBI")) sb.append(i).append(' ');
        }

        if (sb.length() == 0) System.out.println("HE GOT AWAY!");
        else System.out.println(sb.toString());
    }
}