import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static boolean[] visited;
	static int[] li;
	
	private static void dfs(int idx, int start) {
		
		if (idx == m) {
			for (int i : li) sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = start; i <= n; i++) {
			li[idx] = i;
			dfs(idx + 1, i + 1);
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	visited = new boolean[n+1];
    	li = new int[m];
    	
    	dfs(0, 1);
    	System.out.println(sb.toString());
    }
}