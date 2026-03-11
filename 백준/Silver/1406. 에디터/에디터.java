import java.util.*;
import java.io.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    static Deque<Character> left = new ArrayDeque<>();
    static Deque<Character> right = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) left.add(s.charAt(i));
        
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
            case "L": if (!left.isEmpty()) right.add(left.pollLast()); break;
            case "D": if (!right.isEmpty()) left.add(right.pollLast()); break;
            case "B": if (!left.isEmpty()) left.pollLast(); break;
            case "P": left.add(st.nextToken().charAt(0)); break;
            }
        }

        while (!left.isEmpty()) sb.append(left.pollFirst());
        while (!right.isEmpty()) sb.append(right.pollLast());

        System.out.println(sb.toString());
    }
}