import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String answer = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isUpperCase(c)) {
				answer += String.valueOf(c).toLowerCase();
			} else {
				answer += String.valueOf(c).toUpperCase();
			}
		}
		System.out.println(answer);
	}
}
