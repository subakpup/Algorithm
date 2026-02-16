import java.io.*;
import java.math.BigInteger;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	private static void hanoi(int n, int start, int mid, int end) {
		if (n == 1) {
			sb.append(start).append(' ').append(end).append('\n');
			return;
		}
		hanoi(n-1, start, end, mid);
		sb.append(start).append(' ').append(end).append('\n');
		hanoi(n-1, mid, start, end);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		BigInteger k = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);
		System.out.println(k);
		
		if (n <= 20) {
			hanoi(n, 1, 2, 3);
			System.out.println(sb.toString());
		}
	}

}
