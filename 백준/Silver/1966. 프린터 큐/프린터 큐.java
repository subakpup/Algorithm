import java.util.*;
import java.io.*;

class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Deque<Integer> deque = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) deque.add(Integer.parseInt(st.nextToken()));

            int cnt = 0;

            while (!deque.isEmpty()) {
                int max = Collections.max(deque);
                int first = deque.pollFirst();
                --m;

                if (max == first) {
                    ++cnt;
                    if (m < 0) {
                        sb.append(cnt).append('\n');
                        break;
                    }
                } else {
                    deque.addLast(first);
                    if (m < 0) m = deque.size() - 1;
                }
            }
        }

        System.out.println(sb.toString());
    }
}