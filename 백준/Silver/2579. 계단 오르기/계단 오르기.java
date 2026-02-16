
import java.util.*;
import java.io.*;

public class Main {
	static int n, answer;
	static int[] stair, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		stair = new int[n];
		for (int i = 0; i < n; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		if (n == 1) {
			answer = stair[0];
		} else if (n == 2) {
			answer = stair[0] + stair[1];
		} else {
			dp = new int[n];
			dp[0] = stair[0];
			dp[1] = stair[0] + stair[1];
			dp[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);
			
			for (int i = 3; i < n; i++) {
				dp[i] = stair[i] + Math.max(dp[i-2], stair[i-1] + dp[i-3]);
			}
			
			answer = dp[n-1];
		}
		
		System.out.println(answer);
		
	}
}