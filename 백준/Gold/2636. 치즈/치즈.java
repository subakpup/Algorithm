import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int cheese, cnt, time;
	static int[][] map;
	
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	
	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0, 0});
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int r = p[0], c = p[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;

				if (map[nr][nc] == 0) {
					queue.offer(new int[] {nr, nc});
				} else {
					cheese--;
					map[nr][nc] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) cheese++;
			}
		}
		
		cnt = 0; time = 0;
		while (cheese > 0) {
			cnt = cheese;
			time++;
			bfs();
		}
		
		System.out.println(time + "\n" + cnt);
	}
}