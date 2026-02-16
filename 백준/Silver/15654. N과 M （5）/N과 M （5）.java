import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] arr;
	static boolean[] used;
	static List<Integer> nums;
	
	private static void dfs(int depth) {
		if (depth == m) {
			for (int a : arr) sb.append(a).append(' ');
			sb.append('\n');
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!used[i]) {
				used[i] = true;
				arr[depth] = nums.get(i);
				dfs(depth + 1);
				used[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		nums = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(nums);
		
		arr = new int[m];
		used = new boolean[n];
		
		dfs(0);
		
		System.out.println(sb.toString());
	}

}
