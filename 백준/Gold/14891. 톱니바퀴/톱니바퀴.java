import java.util.*;
import java.io.*;

public class Main {
	static int[][] cog = new int[4][8];
	static final int LEFT = 6;
	static final int RIGHT = 2;
	static int answer = 0;
	
	private static void simulate(int idx, int d) {
		int[] dir = new int[4];
		dir[idx] = d;
		
		for (int i = idx - 1; i >= 0; i--) {
			if (cog[i+1][LEFT] == cog[i][RIGHT]) break;
			dir[i] = -dir[i+1];
		}
		
		for (int i = idx + 1; i < 4; i++) {
			if (cog[i-1][RIGHT] == cog[i][LEFT]) break;
			dir[i] = -dir[i-1];
		}
		
		rotate(dir);
	}
	
	private static void rotate(int[] dir) {
		for (int i = 0; i < 4; i++) {
			if (dir[i] == 0) continue;
			
			Deque<Integer> queue = new ArrayDeque<>();
			
			for (int idx = 0; idx < 8; idx++) queue.add(cog[i][idx]);
			
			if (dir[i] == 1) queue.offerFirst(queue.pollLast());
			else if (dir[i] == -1) queue.offerLast(queue.pollFirst());
			
			for (int idx = 0; idx < 8; idx++) cog[i][idx] = queue.pollFirst();
		}
	}
	
	private static void scoring() {
		for (int i = 0; i < 4; i++) {
			if (cog[i][0] == 1) {
				answer += (1 << i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			String line = br.readLine();
			for (int j = 0; j < 8; j++) {
				cog[i][j] = line.charAt(j) - '0';
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			simulate(idx - 1, dir);
		}
		
		scoring();
		System.out.println(answer);
	}

}
