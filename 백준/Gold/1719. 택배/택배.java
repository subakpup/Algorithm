/*
 * Main_1719 택배 (골드 3)
 *  - 메모리: 
 *  - 시간: 
 * 
 * # 문제 정리
 *  - 택배 화물이 각 집하장 사이를 오갈 때 어떤 경로를 거치는지 경로표를 작성
 *  - 정점: 집하장, 간선: 화물이 이동 가능한 경로, 가중치: 이동에 걸리는 시간
 *  
 * # 아이디어
 *  
 */

import java.util.*;
import java.io.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static final int INF = (int) 1e9;
	
	static int n, m;
	static int[][][] dist;
	
	private static void floyd() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j) continue;
					
					if (dist[i][j][0] > dist[i][k][0] + dist[k][j][0]) {
						dist[i][j][0] = dist[i][k][0] + dist[k][j][0];
						dist[i][j][1] = dist[i][k][1];
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dist = new int[n+1][n+1][2];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				Arrays.fill(dist[i][j], INF);
			}
		}
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			int tmp = Math.min(dist[from][to][0], weight);
			dist[from][to][0] = tmp;
			dist[to][from][0] = tmp;
			dist[from][to][1] = to;
			dist[to][from][1] = from;
		}
		
		floyd();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int v = dist[i][j][1];
				sb.append((v == INF) ? "-" : dist[i][j][1]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}