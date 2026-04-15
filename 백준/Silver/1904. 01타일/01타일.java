import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;

    private static int solve(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (dp[n] != -1) return dp[n];

        dp[n] = (solve(n - 1) + solve(n - 2)) % 15746;
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println(solve(n));
    }
}