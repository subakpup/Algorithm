import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge> {
		int u, v, w;
		
		Edge (int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	
	static int n, m;
	static int[] p, s;
	static List<Edge> edges;
	
	private static void makeSet() {
		p = new int[n+1];
		s = new int[n+1];
		for (int i = 1; i <= n; i++) {
			p[i] = i;
			s[i] = 1;
		}
	}
	
	private static int find(int x) {
		if (p[x] == x) return x;
		return p[x] = find(p[x]);
	}
	
	private static boolean union(int a, int b) {
		int ra = find(a), rb = find(b);
		
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
	
	private static int kruskal() {
		Collections.sort(edges);
		makeSet();
		
		int mstCost = 0;
		int usedEdges = 0;
		
		for (Edge e : edges) {
			if (union(e.u, e.v)) {
				mstCost += e.w;
				if (++usedEdges == n - 1) break;
			}
		}
		
		return mstCost;
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	m = Integer.parseInt(br.readLine());
    	
    	edges = new ArrayList<>();
    	for (int i = 0; i < m; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		edges.add(new Edge(a, b, c));
    	}
    	
    	System.out.println(kruskal());
    }
}