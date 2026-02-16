import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int area, cnt, answer;
	static int[][] arr;
	static boolean[][] visited;
	
	public static boolean isIn(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}
	
	public static int bfs(int X, int Y) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		area = 1;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {X, Y});
		visited[X][Y] = true;
		
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int x = p[0];
			int y = p[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (isIn(nx,ny) && arr[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
					area += 1;
				}
			}
		}
		
		return area;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					answer = Math.max(answer, bfs(i,j));
					cnt += 1;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(answer);
		
	}

}
