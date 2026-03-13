import java.util.*;
import java.io.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        while (c-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            List<Double> arr = new ArrayList<>();
            double score = 0;

            for (int i = 0; i < n; i++) {
                arr.add(Double.parseDouble(st.nextToken()));
                score += arr.get(i);
            }

            score /= n;

            int cnt = 0;
            for (double i : arr) if (i > score) ++cnt;

            sb.append(String.format("%.3f", (double) cnt / n * 100)).append("%\n");
        }

        System.out.println(sb.toString());
    }
}