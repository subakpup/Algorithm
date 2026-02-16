import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int v, e;
	static boolean flag;
	static List<ArrayList<Integer>> adj;
	static int[] colors; // 0: 미방문, 1: 그룹1, 2: 그룹2

	private static void solve() {
		flag = true;

		for (int i = 1; i <= v; i++) {
			if (colors[i] == 0) {
				if (!bfs(i)) {
					flag = false;
					return;
				}
			}
		}

	}

	private static boolean bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		colors[start] = 1;

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int nxt : adj.get(cur)) {
				if (colors[nxt] == 0) {
					colors[nxt] = (colors[cur] == 1) ? 2 : 1;
					queue.add(nxt);
				} else if (colors[cur] == colors[nxt]) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			adj = new ArrayList<>();
			for (int i = 0; i <= v; i++) adj.add(new ArrayList<>());

			colors = new int[v + 1];

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj.get(a).add(b);
				adj.get(b).add(a);
			}

			solve();
			
			sb.append(flag ? "YES" : "NO").append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
