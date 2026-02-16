import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		String answer = "==";
		if (a > b) {
			answer = ">";
		} else if (a < b) {
			answer = "<";
		}
		
		System.out.println(answer);	
	}
}
