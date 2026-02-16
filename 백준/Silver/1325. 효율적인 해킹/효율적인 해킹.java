import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static List<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int cnt;
	static int[] isHacked;
	static StringBuilder sb = new StringBuilder();
	
	public static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			
			for (int cur : graph.get(node)) {
				if (!visited[cur]) {
					queue.add(cur);
					visited[cur] = true;
					isHacked[start]++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(b).add(a);
		}
		
		isHacked = new int[n+1];
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n+1];
			bfs(i);
			if (answer < isHacked[i]) answer = isHacked[i];
		}
		
		for (int i = 1; i <= n; i++) {
			if (isHacked[i] == answer) {
				sb.append(i + " ");
			}
		}
		
		System.out.println(sb);
		
	}
}
