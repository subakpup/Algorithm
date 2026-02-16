/*
 * Main_11866_요세푸스문제0_함지수
 * 
 */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		LinkedList<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		
		sb.append("<");
		
		while (!queue.isEmpty()) {
			for (int i = 0; i < k - 1; i++) {
				queue.add(queue.removeFirst());
			}
			sb.append(queue.removeFirst());
			
			if (!queue.isEmpty()) {
				sb.append(", ");
			}
		}
		
		sb.append(">");
		
		System.out.println(sb);
		
	}

}
