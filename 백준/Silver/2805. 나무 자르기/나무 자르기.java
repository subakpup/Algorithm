import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static long m;
	static int[] trees;
	
	private static int binarySearch(int left, int right) {
		long length;
		while (left <= right) {
			int mid = (left + right) / 2;
			length = 0L;
			
			for (int tree : trees) {
				if (tree > mid) {
					length += tree - mid;
				}
			}
			
			if (length >= m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int l = 1;
		int r = 0;
		st = new StringTokenizer(br.readLine());
		trees = new int[n];
		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if (trees[i] > r) r = trees[i];
		}
		
		System.out.println(binarySearch(l, r));
	}

}
