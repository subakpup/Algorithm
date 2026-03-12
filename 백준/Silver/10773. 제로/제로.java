import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        while (n-- > 0) {
            int cur = Integer.parseInt(br.readLine());

            if (cur == 0) deque.pollLast();
            else deque.add(cur);
        }

        int answer = 0;
        for (int i : deque) answer += i;

        System.out.println(answer);
    }
}