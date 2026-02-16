import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		LinkedList<Integer> queue = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < N; t++) {
			String[] cmd = br.readLine().split(" ");
			
			switch (cmd[0]) {
				case "push":
					int val = Integer.parseInt(cmd[1]);
					queue.add(val);
					break;
				case "pop":
					if (queue.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(queue.removeFirst()).append("\n");
					}
					break;
				case "size":
					sb.append(queue.size()).append("\n");
					break;
				case "empty":
					if (queue.isEmpty()) {
						sb.append(1).append("\n");
					} else {
						sb.append(0).append("\n");
					}
					break;
				case "front":
					if (queue.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(queue.peek()).append("\n");
					}
					break;
				case "back":
					if (queue.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						sb.append(queue.peekLast()).append("\n");
					}
					break;
			}
		}
		
		System.out.println(sb);
	}

}
