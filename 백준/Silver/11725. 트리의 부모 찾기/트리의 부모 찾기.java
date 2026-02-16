import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] visited;
	static List<ArrayList<Integer>> graph;
	static StringBuilder sb = new StringBuilder();
	
	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int nxt : graph.get(cur)) {
				if (visited[nxt] != 0) continue;
				
				queue.add(nxt);
				visited[nxt] = cur;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
  		}
		
		visited = new int[n+1];
		bfs();
		
		for (int i = 2; i <= n; i++) {
			sb.append(visited[i]).append('\n');
		}
		System.out.println(sb.toString());
	}

}
