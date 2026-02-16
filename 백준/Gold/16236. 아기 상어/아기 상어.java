import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] map;
	static int sr, sc;
	
	static int shark = 2;
	static int eat = 0;
	static int time = 0;
	
	static final int[] dr = { -1, 0, 0, 1 };
	static final int[] dc = { 0, -1, 1, 0 };
	
	static class Target {
		int r, c, dist;
		
		Target (int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	
	private static void simulate() {
		while (true) {
			Target t = bfs();
			if (t == null) return;
			
			time += t.dist;
			map[t.r][t.c]= 0; 
			sr = t.r; sc = t.c;
			if (++eat == shark) {
				eat = 0;
				++shark;
			}
		}
	}
	
	private static Target bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sr, sc });
		int[][] dist = new int[n][n];
		for (int i = 0; i < n; i++) Arrays.fill(dist[i], -1);
		dist[sr][sc] = 0;
		
		int tDist = Integer.MAX_VALUE;
		int tr = -1, tc = -1;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];
			
			if (dist[r][c] > tDist) continue;
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= n || dist[nr][nc] != -1 || map[nr][nc] > shark) continue;
				
				dist[nr][nc] = dist[r][c] + 1;
				
				if (map[nr][nc] != 0 && map[nr][nc] < shark) {
					if (dist[nr][nc] < tDist) {
						tDist = dist[nr][nc];
						tr = nr; tc = nc;
					} else if (dist[nr][nc] == tDist){
						if (tr > nr || (tr == nr && tc > nc)) {
							tr = nr; tc = nc;
						}
					}
				} else {
					queue.add(new int[] {nr, nc});
				}

			}
		}
		
		return (tr == -1 || tc == -1 || tDist == Integer.MAX_VALUE) ? null : new Target(tr, tc, tDist);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 9) {
					map[i][j] = 0;
					sr = i; sc = j;
					continue;
				}
				map[i][j] = a;
			}
		}
		
		simulate();
		System.out.println(time);
	}
}