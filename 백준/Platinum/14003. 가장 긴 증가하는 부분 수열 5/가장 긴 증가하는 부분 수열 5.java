
import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] arr, posAt, tailIdx, parent;
	static List<Integer> lis = new ArrayList<>();
	
	private static int lowerBound(int target) {
		int left = 0, right = lis.size();
		
		while (left < right) {
			int mid = (left + right) / 2;
			
			if (lis.get(mid) < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		return left;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		posAt = new int[n]; // arr[i]가 들어간 LIS 길이 위치
		parent = new int[n]; // arr[i] 앞에 오는 원소의 인덱스(역추적용)
		Arrays.fill(parent, -1);
		tailIdx = new int[n]; // 길이 (len+1)의 꼬리를 이루는 "원소의 인덱스"
		
		for (int i = 0; i < n; i++) {
			int x = arr[i];
			
			int pos;
			if (lis.isEmpty() || lis.get(lis.size()-1) < x) {
				pos = lis.size();
				lis.add(x);
			} else {
				pos = lowerBound(x);
				lis.set(pos, x);
			}
			
			posAt[i] = pos;
			if (pos > 0) parent[i] = tailIdx[pos - 1];
			tailIdx[pos] = i;
		}
		
		int[] seq = new int[lis.size()];
		int k = tailIdx[lis.size() - 1];
		for (int i = lis.size() - 1; i >= 0; i--) {
			seq[i] = arr[k];
			k = parent[k];
		}
		
		sb.append(lis.size() + "\n");
		for (int v : seq) sb.append(v + " ");
		System.out.println(sb.toString());
	}
}