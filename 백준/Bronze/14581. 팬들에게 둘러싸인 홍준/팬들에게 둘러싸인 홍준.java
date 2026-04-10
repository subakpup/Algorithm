import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append(":fan::fan::fan:\n:fan::" + s + "::fan:\n:fan::fan::fan:");

        System.out.println(sb.toString());
    }
}