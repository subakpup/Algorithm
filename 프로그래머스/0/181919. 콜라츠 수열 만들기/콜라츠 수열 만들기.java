import java.util.*;

class Solution {
    public List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<>();
        
        while (true) {
            answer.add(n);
            
            if (n == 1) break;
            
            if (n % 2 == 0) n /= 2;
            else n = 3 * n + 1;
        }
        
        return answer;
    }
}