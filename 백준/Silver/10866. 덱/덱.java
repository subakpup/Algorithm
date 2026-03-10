import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] deque = new int[20001];
    static int left = 10000, right = 10000;
    
    private static void pushFront(int num) {
        deque[--left] = num;
    }

    private static void pushBack(int num) {
        deque[right++] = num;
    }

    private static void popFront() {
        if (left == right) sb.append(-1).append('\n');
        else sb.append(deque[left++]).append('\n');
    }

    private static void popBack() {
        if (left == right) sb.append(-1).append('\n');
        else sb.append(deque[--right]).append('\n');
    }

    private static void size() {
        sb.append(right - left).append('\n');
    }

    private static void empty() {
        if (left == right) sb.append(1).append('\n');
        else sb.append(0).append('\n');
    }

    private static void front() {
        if (left == right) sb.append(-1).append('\n');
        else sb.append(deque[left]).append('\n');
    }

    private static void back() {
        if (left == right) sb.append(-1).append('\n');
        else sb.append(deque[right - 1]).append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push_front": pushFront(Integer.parseInt(st.nextToken())); break;
                case "push_back": pushBack(Integer.parseInt(st.nextToken())); break;
                case "pop_front": popFront(); break;
                case "pop_back": popBack(); break;
                case "size": size(); break;
                case "empty": empty(); break;
                case "front": front(); break;
                case "back": back(); break;
            }
        }

        System.out.println(sb.toString());
    }
}