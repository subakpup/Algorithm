import java.util.*;

class Solution {
    public List solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();
        
        Turn:
        for (int i = l; i <= r; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != '5' && s.charAt(j) != '0') continue Turn;
            }
            
            answer.add(Integer.parseInt(s));
        }
        
        if (answer.isEmpty()) answer.add(-1);
        return answer;
    }
}