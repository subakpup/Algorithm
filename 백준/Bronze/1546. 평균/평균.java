
import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (max < arr[i]) max = arr[i];
		}
		
		double answer = 0L;
		for (int i = 0; i < n; i++) {
			answer += (double) arr[i] / max * 100;
		}
		System.out.println(answer / n);
	}
}
