/*
 * Main_2565 전깃줄 (골드 5)
 *  - 메모리: 
 *  - 시간: 
 *  
 * 
 * 
 */

import java.util.*;
import java.io.*;

public class Main {
	
	static class Pair implements Comparable<Pair> {
		int a, b;
		
		Pair (int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Pair o) {
			return this.a - o.a;
		}
	}
	
	static int n;
	static int[] dp;
	static Pair[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dp = new int[n];
		Arrays.fill(dp, 1);
		
		arr = new Pair[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Pair(a, b);
		}
		
		Arrays.sort(arr);
		
		int answer = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i].b > arr[j].b) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(n - answer);
	}
}
