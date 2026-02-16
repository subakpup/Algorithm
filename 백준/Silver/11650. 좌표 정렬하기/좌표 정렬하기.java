import java.util.*;
import java.io.*;

public class Main {
	
	static class Pos implements Comparable<Pos> {
		int x, y;
		
		Pos (int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Pos o) {
			if (this.x == o.x) return this.y - o.y;
			return this.x - o.x;
		}
	}
	
	static int n;
	static Pos[] pos;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		pos = new Pos[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pos[i] = new Pos(x, y);
		}
		Arrays.sort(pos);
		
		for (Pos p : pos) sb.append(p.x + " " + p.y + "\n");
		System.out.println(sb.toString());
	}

}
