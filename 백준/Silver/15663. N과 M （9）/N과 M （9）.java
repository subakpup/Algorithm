import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] num, arr;
	static boolean[] visited;
	
	private static void dfs(int depth) {
		if (depth == m) {
			for (int a : arr) sb.append(a).append(' ');
			sb.append('\n');
			return;
		}
		
		int prev = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i] && prev != num[i]) {
				visited[i] = true;
				prev = num[i];
				arr[depth] = num[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		arr = new int[m];
		visited = new boolean[n];
		dfs(0);
		
		System.out.println(sb.toString());
	}

}
