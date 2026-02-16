import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] a;
	static int b, c;
	
	public static long func() {
		long answer = n;
		for (int i = 0; i < n; i++) {
			a[i] -= b;
			if (a[i] > 0) {
				if (a[i] % c == 0) {
					answer += a[i] / c; 
				} else {
					answer += a[i] / c + 1;
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		System.out.println(func());
		
	}

}
