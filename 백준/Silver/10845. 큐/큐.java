import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] queue;
	
	static int size = 0;
	static int start = 0;
	
	private static void push(int x) {
		queue[size + start] = x;
		size++;
	}
	
	private static int pop() {
		if (size == 0) return -1;
		size--;
		return queue[start++];
	}
	
	private static int empty() {
		return size == 0 ? 1 : 0;
	}
	
	private static int front() {
		return (size == 0) ? -1 : queue[start];
	}
	
	private static int back() {
		return (size == 0) ? -1 : queue[start + size-1];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		queue = new int[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			switch (cmd) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(pop()).append('\n');
				break;
			case "size":
				sb.append(size).append('\n');
				break;
			case "empty":
				sb.append(empty()).append('\n');
				break;
			case "front":
				sb.append(front()).append('\n');
				break;
			case "back":
				sb.append(back()).append('\n');
				break;
			}
			
		}
		
		System.out.println(sb.toString());
	}
}
