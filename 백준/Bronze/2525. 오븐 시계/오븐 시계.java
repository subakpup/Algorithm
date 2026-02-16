import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(br.readLine());
		
		b += c;
		
		while (true) {
			if (b < 60) break;
			a += 1;
			b -= 60;
			if (a > 23) {
				a -= 24;
			}
		}
		
		System.out.println(a + " " + b);
		
	}

}
