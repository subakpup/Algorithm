import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[] arr;
	
	private static void simulate(int a, int b) {
		int l = b - a + 1;
		int[] tmp = new int[l];
		int idx = 0;
		for (int i = a; i <= b; i++) {
			tmp[idx++] = arr[i];
		}
		
		int[] rev = new int[l];
		for (int i = 0; i < l; i++) {
			rev[i] = tmp[l - i - 1];
		}
		
		idx = 0;
		for (int i = a; i <= b; i++) {
			arr[i] = rev[idx++];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		for (int i = 1; i <= n; i++) arr[i-1] = i;
		
		for (int idx = 0; idx < m; idx++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			simulate(a, b);
		}
		
		for (int v : arr) System.out.print(v + " ");
	}

}
