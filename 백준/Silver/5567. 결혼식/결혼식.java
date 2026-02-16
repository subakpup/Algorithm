import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static boolean[][] arr;
	static boolean[] visited;
	static int cnt;
	
	public static void bfs(int start) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {start, 0});
		visited[start] = true;
		cnt = 0;
		
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int node = p[0];
			int depth = p[1];
			
			if (depth >= 2) break;
			
			for (int i = 1; i <= n; i++) {
				if (!visited[i] && arr[node][i]) {
					queue.add(new int[] {i, depth + 1});
					visited[i] = true;
					cnt++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		arr = new boolean[n+1][n+1];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = true;
			arr[b][a] = true;
		}
		
		visited = new boolean[n+1];
		bfs(1);
		System.out.println(cnt);
	}
}
