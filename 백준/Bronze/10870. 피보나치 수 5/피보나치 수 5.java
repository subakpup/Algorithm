import java.io.*;

class Main {

    private static int solve(int n) {
        if (n <= 1) return n;

        int prev1 = 0;
        int prev2 = 1;
        int cur = 0;

        for (int i = 2; i <= n; i++) {
            cur = prev1 + prev2;
            prev1 = prev2;
            prev2 = cur;
        }

        return cur;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solve(Integer.parseInt(br.readLine())));
    }
}