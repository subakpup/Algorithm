import java.util.*;
import java.io.*;

public class Main {
	static int k, w, h;
	static int[][] map;
	
	static final int INF = 1_000_000_000;
	static final int[] dr = { -1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1 };
	static final int[] dc = { 0, 0, -1, 1, -2, -1, 1, 2, -2, -1, 1, 2 };
	
	private static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { 0, 0, 0 });
		
		int[][][] dist = new int[h][w][k+1];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				Arrays.fill(dist[i][j], INF);
			}
		}

		dist[0][0][0] = 0;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1], jump = cur[2];
			
			for (int i = 0; i < 12; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				int nextJump = (i > 3) ? jump + 1 : jump;
				
				if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
				if (nextJump > k || map[nr][nc] == 1 || dist[nr][nc][nextJump] != INF) continue;
				
				dist[nr][nc][nextJump] = dist[r][c][jump] + 1;
				queue.add(new int[] { nr, nc, nextJump });
			}
		}
		
		int answer = INF;
		for (int i = 0; i <= k; i++) answer = Math.min(answer, dist[h-1][w-1][i]);
		
		return answer == INF ? -1 : answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
	}

}
