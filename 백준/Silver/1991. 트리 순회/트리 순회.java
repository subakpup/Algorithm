import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static Map<String, String[]> tree = new HashMap<>();
	
	public static String preorder(String node) {
		if (node.equals(".")) {
			return "";
		}
        
		String left = tree.get(node)[0];
		String right = tree.get(node)[1];
		return node + preorder(left) + preorder(right);
	}
	
	public static String inorder(String node) {
		if (node.equals(".")) {
			return "";
		}
		
		String left = tree.get(node)[0];
		String right = tree.get(node)[1];
		return inorder(left) + node + inorder(right);
	}

	public static String postorder(String node) {
		if (node.equals(".")) {
			return "";
		}
		
		String left = tree.get(node)[0];
		String right = tree.get(node)[1];
		return postorder(left) + postorder(right) + node;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String root = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			tree.put(root, new String[] {left, right});
		}
		
		System.out.println(preorder("A"));
		System.out.println(inorder("A"));
		System.out.println(postorder("A"));
	}

}
