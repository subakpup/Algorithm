import java.util.*;
import java.io.*;

public class Main {
	static int n, answer;
	static PriorityQueue<Long> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		
		answer = 0;

		while (pq.size() > 1) {
			long a = pq.poll();
			long b = pq.poll();
			
			answer += a + b;
			pq.add(a + b);
		}
		
		System.out.println(answer);
	}

}
