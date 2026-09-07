import java.util.*;

class Solution {
    public List solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<>();
        
        for (String str : intStrs) {
            StringBuilder sb = new StringBuilder();
            for (int i = s; i < s + l; i++) {
                sb.append(str.charAt(i));
            }
            
            int n = Integer.parseInt(sb.toString());
            
            if (n > k) answer.add(n);
        }
        
        return answer;
    }
}