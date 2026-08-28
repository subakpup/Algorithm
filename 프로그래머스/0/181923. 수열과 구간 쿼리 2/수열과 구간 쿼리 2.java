import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        
        for (int[] query : queries) {
            int min = 1000001;
            for (int i = query[0]; i <= query[1]; i++) {
                if (arr[i] > query[2]) min = Math.min(min, arr[i]);
            }
            
            answer.add(min == 1000001 ? -1 : min);
        }
        
        return answer;
    }
}