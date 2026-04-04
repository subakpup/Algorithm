import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) deque.add(i);

        while (true) {
            if (deque.size() == 1) {
                System.out.println(deque.poll());
                break;
            }

            deque.pollFirst();
            deque.addLast(deque.pollFirst());
        }
    }
}