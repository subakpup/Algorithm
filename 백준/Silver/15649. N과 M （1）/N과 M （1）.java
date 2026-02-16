import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static boolean[] visited;
	static int[] li;
	
	private static void dfs(int idx) {
		
		if (idx == m) {
			for (int i : li) sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				li[idx] = i;
				dfs(idx + 1);
				visited[i] = false;
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	visited = new boolean[n+1];
    	li = new int[m];
    	
    	dfs(0);
    	System.out.println(sb.toString());
    }
}