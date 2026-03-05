import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static Deque<Integer> cards;

    private static void solve() {

        while (!cards.isEmpty()) {
            sb.append(cards.pollFirst()).append(' ');
            
            if (!cards.isEmpty()) {
                cards.offerLast(cards.pollFirst());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        cards = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) cards.offer(i);

        solve();

        System.out.println(sb.toString());
    }
}