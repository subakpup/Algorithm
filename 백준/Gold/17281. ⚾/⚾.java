
import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] order = new int[9];
	static boolean[] used = new boolean[9];
	static int[][] inning;
	static int answer = 0;
	
	private static void func(int p) {
		// 선수 배치가 완료되었다면, 최대 점수 갱신
		if (p == 9) {
			answer = Math.max(answer, simulate());
			return;
		}
		
		// 4번 타자는 1번으로 고정
		if (p == 3) {
			func(p+1);
			return;
		}
		
		// 2번타자부터 배치 시작
		for (int i = 1; i < 9; i++) {
			if (used[i]) continue;
			used[i] = true;
			order[p] = i;
			func(p+1);
			used[i] = false;
		}
		
	}
	
	private static int simulate() {
		int score = 0; // 현재 점수
		int idx = 0; // 현재 타자(다음 이닝에도 유지)
		
		for (int i = 0; i < n; i++) {
			int out = 0; // 아웃
			boolean b1 = false, b2 = false, b3 = false; // 1루, 2루, 3루
			
			while (out < 3) {
				int player = order[idx];
				int result = inning[i][player];
				
				if (result == 0) {
					out++;
				} else if (result == 1) {
					if (b3) score++;
					b3 = b2;
					b2 = b1;
					b1 = true;
				} else if (result == 2) {
					if (b3) score++;
					if (b2) score++;
					b3 = b1;
					b2 = true;
					b1 = false;
				} else if (result == 3) {
					if (b3) score++;
					if (b2) score++;
					if (b1) score++;
					b3 = true;
					b2 = false;
					b1 = false;
				} else if (result == 4) {
					if (b3) score++;
					if (b2) score++;
					if (b1) score++;
					b3 = false;
					b2 = false;
					b1 = false;
					score++;
				}
				idx = (idx + 1) % 9;
			}
			
		}
		return score;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		inning = new int[n][9];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		order[3] = 0;
		used[0] = true;
		
		func(0);
		System.out.println(answer);
	}

}
