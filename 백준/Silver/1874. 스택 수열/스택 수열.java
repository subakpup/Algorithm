import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        int cur = 1;
        while (n-- > 0) {
            int target = Integer.parseInt(br.readLine());

            while (cur <= target) {
                deque.add(cur++);
                sb.append('+').append('\n');
            }

            if (!deque.isEmpty() && deque.peekLast() == target) {
                deque.pollLast();
                sb.append('-').append('\n');
            } else {
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }
        }

        System.out.println(sb.toString());
    }
}