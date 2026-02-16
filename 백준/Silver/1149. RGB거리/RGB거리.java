/*
 * Main_1149 RGB거리 (실버 1)
 *  - 메모리: 
 *  - 시간: 
 *  
 * # 문제 정리
 *  - 집 N개
 *  - 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집까지 순서대로 존재
 *  - 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어짐
 *  - 다음 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값 출력
 *   * i번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 함
 *  
 * # 아이디어
 *  - i번째에서 빨간집을 선택했을 때, 초록 or 파랑을 선택한 최솟값을 더해준다.
 *  - 마지막 인덱스에서 3개의 집 중 최솟값을 출력
 */

import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] cost, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cost = new int[n+1][3];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n+1][3];
		for (int i = 1; i <= n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
		}
		
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (answer > dp[n][i]) answer = dp[n][i];
		}
		System.out.println(answer);
	}
}