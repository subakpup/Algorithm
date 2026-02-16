import java.util.*;
import java.io.*;

public class Main {
	static int n, white, blue;
	static int[][] map;

	private static void quad(int x, int y, int len) {
		int point = map[x][y];
		boolean flag = true;
		
		for (int r = x; r < x + len; r++) {
			for (int c = y; c < y + len; c++) {
				if (map[r][c] != point) {
					flag = false;
				}
			}
		}
		
		if (!flag) {
			int half = len / 2;
			quad(x, y, half);
			quad(x, y + half, half);
			quad(x + half, y, half);
			quad(x + half, y + half, half);
			return;
		} 
		
		if (point == 0) {
			white++;
		} else {
			blue++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		white = 0; blue = 0;
		quad(0, 0, n);
		System.out.println(white + "\n" + blue);
	}

}
