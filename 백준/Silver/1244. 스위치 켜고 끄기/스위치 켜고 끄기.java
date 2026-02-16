import java.util.*;
import java.io.*;

public class Main {
	static int n,s,idx;
	static int[] arr;
	static String gender;
	
	public static void boy(int idx) {
		for (int i = idx; i < n; i += idx + 1) {
			arr[i] = 1 - arr[i];
		}
	}
	
	public static void girl(int idx) {
		int left = idx - 1;
		int right = idx + 1;
		arr[idx] = 1 - arr[idx];
		
		while (left >= 0 && right < n && arr[left] == arr[right]) {
			arr[left] = 1 - arr[left];
			arr[right] = 1 - arr[right];
			left--;
			right++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		s = Integer.parseInt(br.readLine());
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			gender = st.nextToken();
			idx = Integer.parseInt(st.nextToken()) - 1;
			if (gender.equals("1")) {
				boy(idx);
			} else {
				girl(idx);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(arr[i]).append(" ");
			if ((i+1) % 20 == 0) sb.append("\n");
		}
		System.out.println(sb);
		
		
	}

}
