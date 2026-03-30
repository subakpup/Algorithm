import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();

            if (s.equals(".")) break;
            
            Deque<Boolean> deque = new ArrayDeque<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(') deque.add(true);
                else if (c == '[') deque.add(false);
                else if (c == ')') {
                    if (deque.isEmpty() || !deque.peekLast()) {
                        deque.add(false);
                        break;
                    }
                    deque.pollLast();
                }
                else if (c == ']') {
                    if (deque.isEmpty() || deque.peekLast()) {
                        deque.add(true);
                        break;
                    }
                    deque.pollLast();
                }
            }

            if (deque.isEmpty()) sb.append("yes\n");
            else sb.append("no\n");
        }

        System.out.println(sb.toString());
    }
}