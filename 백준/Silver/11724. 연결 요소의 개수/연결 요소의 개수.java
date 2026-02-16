import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static boolean[][] graph;
	static boolean[] visited;
	
	public static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			
			for (int i = 1; i <= n; i++) {
				if (!visited[i] && graph[node][i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		System.setIn(new FileInputStream("Test3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new boolean[n+1][n+1];
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = true;
			graph[b][a] = true;
		}
		
		int answer = 0;
		visited = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				bfs(i);
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}
