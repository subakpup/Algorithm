/*
 * Main_1107 리모컨 (골드 4)
 *  - 메모리: 
 *  - 시간: 
 *  
 * # 문제 정리
 * 
 * # 아이디어
 *  
 */

import java.util.*;
import java.io.*;

public class Main {
	static int n, m, answer;
	static boolean[] broken;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		if (m == 0) {
			answer = Math.min(String.valueOf(n).length(), Math.abs(n - 100));
			System.out.println(answer);
			return;
		}
		
		broken = new boolean[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			broken[Integer.parseInt(st.nextToken())] = true;
		}
		
		answer = Math.abs(n - 100);
		
		if (answer == 0) {
			System.out.println(answer);
			return;
		}
		
		for (int i = 0; i <= 1000000; i++) {
			String target = String.valueOf(i);
			boolean flag = true;
			
			for (int j = 0; j < target.length(); j++) {
				if (broken[target.charAt(j) - '0']) {
					flag = false;
					break;
				} 
			}
			
			if (flag) {
				int cost = target.length() + Math.abs(i - n);
				if (answer > cost) answer = cost;
			}
		}
		System.out.println(answer);
	}
}