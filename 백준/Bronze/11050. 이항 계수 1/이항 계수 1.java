import java.util.*;
import java.io.*;

public class Main {
	static int n, k;
	
	private static int factorial(int a) {
		int res = 1;
		for (int i = 2; i <= a; i++) {
			res *= i;
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int answer = factorial(n) / (factorial(k) * factorial(n - k));
		
		System.out.println(answer);
	}
}
