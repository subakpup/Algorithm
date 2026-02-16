import java.io.*;
import java.util.*;

public class Main {
	static long a, b;
	static long answer;
	
	public static long cal(long a, long b) {
		return (a+b) * (a-b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		answer = cal(a, b);
		System.out.println(answer);
	}
}
