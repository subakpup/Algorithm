import java.util.*;
import java.io.*;

public class Main {
	static int v, e, cnt;
	static boolean[] visited;
	static List<ArrayList<Integer>> graph;
	
	private static void dfs(int cur) {
		visited[cur] = true;
		
		for (int nxt : graph.get(cur)) {
			if (!visited[nxt]) {
				dfs(nxt);
				cnt++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= v; i++) graph.add(new ArrayList<>());
		
		e = Integer.parseInt(br.readLine());
		for (int i = 0; i < e; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		visited = new boolean[v+1];
		dfs(1);
		
		System.out.println(cnt);
	}
}