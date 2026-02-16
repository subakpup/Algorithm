import java.util.*;
import java.io.*;

public class Main {
	
	static class Edge {

		int from, to;
		
		public Edge(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}

	}
	
	static int n, m;
	static int[][] edges;
	static int[] p, s;
	
	private static void make() {
		p = new int[n];
		s = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
			s[i] = 1;
		}
	}
	
	private static int find(int x) {
		while (p[x] != x) {
			p[x] = p[p[x]];
			x = p[x];
		}
		return x;
	}
	
	private static boolean union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		
		if (ra == rb) return false;
		
		if (s[ra] < s[rb]) {
			int tmp = ra;
			ra = rb;
			rb = tmp;
		}
		
		p[rb] = ra;
		s[ra] += s[rb];
		return true;
	}
	
	private static int kruskal(Edge[] edges) {
		int usedEdges = 0;
		boolean flag = false;
		
		for (Edge e : edges) {
			boolean tmp = union(e.from, e.to);
			++usedEdges;
			if (!tmp) {
				flag = true;
				break;
			}
		}
		
		return flag ? usedEdges : 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		Edge[] edges = new Edge[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(a, b);
		}
		
		make();
		System.out.println(kruskal(edges));

	}

}
