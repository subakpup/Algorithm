import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) answer += Character.toLowerCase(s.charAt(i));
            else answer += Character.toUpperCase(s.charAt(i));
        }
        
        System.out.println(answer);
    }
}