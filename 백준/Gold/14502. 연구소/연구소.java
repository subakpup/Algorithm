/*
 * - N*M 연구소
 * - 빈 칸 or 벽
 * - 일부 칸은 바이러스 존재
 *  - 상하좌우 인접한 빈 칸으로 퍼짐
 * - 벽을 3개 세울 수 있음
 * - 벽을 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라 함
 *  - 안전영역 크기의 최댓값
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n, m, answer;
	static int[][] map;
	static List<int[]> virus;
	
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	
	private static void makeWall(int wall) {
		if (wall == 3) {
			bfs();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(wall + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	private static void bfs() {
		int[][] tmp = new int[n][m];
		for (int i = 0; i < n; i++) tmp[i] = Arrays.copyOf(map[i], map[i].length);
		
		Queue<int[]> queue = new ArrayDeque<>();
		for (int[] v : virus) queue.add(v);
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				if (tmp[nr][nc] == 0) {
					tmp[nr][nc] = 2;
					queue.add(new int[] { nr, nc });
				}
			}
		}
		
		counting(tmp);
	}
	
	private static void counting(int[][] tmp) {
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tmp[i][j] == 0) ++cnt;
			}
		}
		
		answer = Math.max(answer, cnt);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		virus = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) virus.add(new int[] { i, j });
			}
		}
		
		answer = 0;
		makeWall(0);
		
		System.out.println(answer);
	}

}
