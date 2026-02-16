import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int score = Integer.parseInt(br.readLine());
		
		char answer = 'F';
		if (score >= 90) {
			answer = 'A';
		} else if (score >= 80) {
			answer = 'B';
		} else if (score >= 70) {
			answer = 'C';
		} else if (score >= 60) {
			answer = 'D';
		}
		
		System.out.println(answer);
		
	}
}
