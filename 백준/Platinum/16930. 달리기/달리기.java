import java.util.*;
import java.io.*;

public class Main {
	static int n, m, k, sr, sc, er, ec;
	static int answer = -1;
	static char[][] map;
	static int[][] dist;
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	private static void bfs(int sr, int sc) {
		dist = new int[n][m];
		for (int[] line : dist) Arrays.fill(line, Integer.MAX_VALUE);
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sr, sc });
		dist[sr][sc] = 0;

		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int r = p[0];
			int c = p[1];
			if (r == er && c == ec) {
				answer = dist[r][c];
				return;
			}

			int tmp = dist[r][c] + 1;

			for (int i = 0; i < 4; i++) {
				for (int j = 1; j <= k; j++) {
					int nr = r + dr[i] * j;
					int nc = c + dc[i] * j;

					if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
					if (map[nr][nc] == '#') break;
					if (dist[nr][nc] < tmp) break;
					if (dist[nr][nc] == tmp) continue;
					
					dist[nr][nc] = tmp;
					queue.add(new int[] { nr, nc });
					
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// --------------솔루션 코드를 작성하세요.---------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken()) - 1;
		sc = Integer.parseInt(st.nextToken()) - 1;
		er = Integer.parseInt(st.nextToken()) - 1;
		ec = Integer.parseInt(st.nextToken()) - 1;

		bfs(sr, sc);

		System.out.println(answer);
	}

}
