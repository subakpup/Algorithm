import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int left, right, total;
	static int[] arr;
	
	private static void solve() {
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (calc(mid) > m) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(right);
	}
	
	private static int calc(int a) {
		int total = 0;
		for (int i = 0; i < n; i++) {
			total += Math.min(a, arr[i]);
		}
		return total;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		left = 0; right = -1;
		total = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
			total += arr[i];
		}
		
		m = Integer.parseInt(br.readLine());
		
		solve();
	}

}
